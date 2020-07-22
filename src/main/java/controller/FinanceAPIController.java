package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.math.BigDecimal;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.*;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;


//Refer to https://github.com/sstrickx/yahoofinance-api
@RestController
@RequestMapping("/finance_api")
@Api(value = "API controller" )
@Component
public class FinanceAPIController {

		Stock stock;
		List<HistoricalQuote> history = null;
		String[] Nifty50companies = new String[]{"BAJAJ-AUTO.NS",
					          "EICHERMOT.NS",
					          "HEROMOTOCO.NS", 
					          "M&M.NS",
					          "MARUTI.NS",
					          "TATAMOTORS.NS", 
					          "AXISBANK.NS", 
					          "HDFCBANK.NS",
					          "ICICIBANK.NS", 
					          "INDUSINDBK.NS", 
					          "KOTAKBANK.NS", 
					          "SBIN.NS",
					          "GRASIM.NS" , 
					          "SHREECEM.NS", 
					          "ULTRACEMCO.NS", 
					          "UPL.NS",
					          "LT.NS", 
					          "ASIANPAINT.NS", 
					          "BRITANNIA.NS", 
					          "HINDUNILVR.NS", 
					          "ITC.NS",
					          "NESTLEIND.NS", 
					          "TITAN.NS",
					          "BPCL.NS", 
					          "GAIL.NS", 
					          "IOC.NS", 
					          "ONGC.NS", 
					          "RELIANCE.NS", 
					          "NTPC.NS",
					          "POWERGRID.NS", 
					          "COALINDIA.NS", 
					          "BAJFINANCE.NS", 
					          "BAJAJFINSV.NS", 
					          "HDFC.NS",
					          "HCLTECH.NS", 
					          "INFY.NS", 
					          "TCS.NS", 
					          "TECHM.NS", 
					          "WIPRO.NS", 
					          "ADANIPORTS.NS", 
					          "ZEEL.NS", 
					          "HINDALCO.NS", 
					          "JSWSTEEL.NS", 
					          "TATASTEEL.NS", 
					          "VEDL.NS", 
					          "CIPLA.NS", 
					          "DRREDDY.NS", 
					          "SUNPHARMA.NS", 
					          "BHARTIARTL.NS", 
					          "INFRATEL.NS"};
		
		private static final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(Api.class);
		
		@GetMapping("/fetch_data")
		public List<String> FetchHistoricData()
		{
			List<String> return_info = new ArrayList<>();
			try {
				Map<String,Stock> stocks = YahooFinance.get(Nifty50companies);
				for(String company : Nifty50companies)
				{
					Stock s =stocks.get(company);
					s.print();
					return_info.add(s.toString());
					
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			return return_info;
		}
}
