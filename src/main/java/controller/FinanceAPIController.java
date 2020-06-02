package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//Refer to https://github.com/sstrickx/yahoofinance-api
@RestController
@RequestMapping("/alpha_vantage_api")
@Api(value = "API controller" )
@Component
public class FinanceAPIController {

	String[] symbols = new String[] {"IDEA.NS", "BABA", "TSLA", "AIR.PA", "YHOO"};
	
	@GetMapping("/displayAllStocks")
	@ApiOperation(value = "Get all stocks.", notes = "Returns a map of all stocks.")
	public Map<String,Stock> getAllStocks()
	{
		Map<String,Stock> map = new HashMap<>();
		
		
		return map;
	}
	
	@GetMapping("/test")
	public String test()
	{
		Stock stock;
		String tmp = null;
		try {
			stock = YahooFinance.get("INTC"); //for intel
			BigDecimal price = stock.getQuote().getPrice();
			BigDecimal change = stock.getQuote().getChangeInPercent();
			BigDecimal peg = stock.getStats().getPeg();
			BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
			tmp = ("\nPrice:"+price+"\nChange:"+change+"\nPeg:"+peg+"\nDividend: "+dividend);
			stock.print();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
		
	}
}
