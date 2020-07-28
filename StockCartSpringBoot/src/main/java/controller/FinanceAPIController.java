package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import yahoofinance.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.RStock;
import model.SavedStocks;
import service.SavedStocksService;
import service.UserService;

@RestController
@RequestMapping("/finance_api")
@Api(value = "API controller")
@Component
public class FinanceAPIController {

	@Autowired
	SavedStocksService saved_stocks_service;
	
	@Autowired
	UserService user_service;
	
	Map<String, List<String>> sector_wise_companies = Map.ofEntries(
			new AbstractMap.SimpleEntry<String, List<String>>("Automobile",
					new ArrayList<>(Arrays.asList("BAJAJ-AUTO.NS", "EICHERMOT.NS", "HEROMOTOCO.NS", "M&M.NS",
							"MARUTI.NS", "TATAMOTORS.NS"))),
			new AbstractMap.SimpleEntry<String, List<String>>("Banking",
					new ArrayList<>(Arrays.asList("AXISBANK.NS", "HDFCBANK.NS", "ICICIBANK.NS ", " INDUSINDBK.NS ",
							"KOTAKBANK.NS ", " SBIN.NS"))),
			new AbstractMap.SimpleEntry<String, List<String>>("Cement",
					new ArrayList<>(Arrays.asList("ASIANPAINT.NS", "BRITANNIA.NS", "HINDUNILVR.NS", "ITC.NS",
							"NESTLEIND.NS", "TITAN.NS"))),
			new AbstractMap.SimpleEntry<String, List<String>>("Energy",
					new ArrayList<>(Arrays.asList("BPCL.NS", "GAIL.NS", "IOC.NS", "ONGC.NS", "RELIANCE.NS", "NTPC.NS",
							"POWERGRID.NS"))),
			new AbstractMap.SimpleEntry<String, List<String>>("Information Technology",
					new ArrayList<>(Arrays.asList("HCLTECH.NS", "INFY.NS", "TCS.NS", "TECHM.NS", "WIPRO.NS"))));

	@GetMapping("/fetch_data/{category}")
	@ApiOperation(value = "fetch sector data", notes = "Fetch data from yahoo finance api for particular category")
	public Map<String, String> FetchHistoricData(@PathVariable("category") String category) {
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> res = new HashMap<>();
		
		try {
			List<String> companies = sector_wise_companies.get(category);

			String[] tmp = new String[companies.size()];
			for (int i = 0; i < tmp.length; i++)
				tmp[i] = companies.get(i);

			Map<String, Stock> stocks = YahooFinance.get(tmp);
			List<Stock> sorted_stocks = new ArrayList<>(stocks.values());

			Collections.sort(sorted_stocks, new Comparator<Stock>() {
				public int compare(Stock s1, Stock s2) {
					return s2.getQuote().getPrice().compareTo(s1.getQuote().getPrice());
				}
			});

			if (stocks.size() == 0)
				System.out.print("Unable to fetch data from yahoo api.");
			else {
				for (Stock company : sorted_stocks) {
					if (company == null)
						continue;
					if (res.size() == 5)
						break;
					RStock t = new RStock(company, category);
					System.out.println(t);
					res.put(company.getSymbol(), mapper.writeValueAsString(t));
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return res;

	}

	@PostMapping("/save_stock")
	@ApiOperation(value = "save stock data", notes = "Save the stock details for given user")
	public void saveStock(@RequestBody RStock stock)
	{
		long user_id = user_service.getCurrentUserId();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		SavedStocks ss = new SavedStocks(user_id, dtf.format(now), stock);
		saved_stocks_service.saveStock(ss);		
	}
	
	@GetMapping("/get_all_saved")
	@ApiOperation(value = "get all saved", notes = "Get all the stocks saved by the given user")
	public Collection<SavedStocks> getSavedStocks()
	{
		long user_id = user_service.getCurrentUserId();
		return saved_stocks_service.getAllSavedStocksById(user_id);
	}
	
	@GetMapping("/fetch_data_all") // fetches data for all categories
	@ApiOperation(value = "fetch data", notes = "Fetch data from yahoo finance api from all categories")
	public Map<String, String> FetchHistoricDataALL() {
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> res = new HashMap<>();
		
		try {
			for (String sector : sector_wise_companies.keySet()) {
				List<String> companies = sector_wise_companies.get(sector);
				
				String[] tmp = new String[companies.size()];
				for (int i = 0; i < tmp.length; i++)
					tmp[i] = companies.get(i);
				
				Map<String, Stock> stocks = YahooFinance.get(tmp);
				List<Stock> all_stocks = new ArrayList<>(stocks.values());
				
				for (Stock company : all_stocks) {
					if (company == null)
						continue;
					RStock t = new RStock(company, sector);
					System.out.println(t);
					res.put(company.getSymbol(), mapper.writeValueAsString(t));
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return res;
	}

}
