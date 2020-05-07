package controller;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import yahoofinance.*;

@RestController
@RequestMapping("/yahoo_api")
@Api(value = "Yahoo API controller" )
@Component
public class YahooAPIController {

	String[] symbols = new String[] {"IDEA.NS", "BABA", "TSLA", "AIR.PA", "YHOO"};
	
	@GetMapping("/displayAllStocks")
	@ApiOperation(value = "Get all stocks.", notes = "Returns a list of all stocks.")
	public Map<String,Stock> getStocks()
	{
		Map<String, Stock> stocks = null;
		try {
			stocks = YahooFinance.get(symbols);
			for(String company : stocks.keySet())
				stocks.get(company).print();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return stocks;
	}

}
