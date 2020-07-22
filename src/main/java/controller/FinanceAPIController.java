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
@RequestMapping("/alpha_vantage_api")
@Api(value = "API controller" )
@Component
public class FinanceAPIController {

		Stock stock;
		List<HistoricalQuote> history = null;
		ArrayList<String> dates = new ArrayList<String>();
		ArrayList<BigDecimal> ClosingPrice = new ArrayList<BigDecimal>();
		ArrayList<Double> moneyValue = new ArrayList<Double>();
		ArrayList<Double> percentReturn = new ArrayList<Double>();
		ArrayList<Double> hvarlist = new ArrayList<Double>();
		ArrayList<String> list = new ArrayList<String>() ;

		private static final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(Api.class);

		public long getAllDays(int dayOfWeek, long businessDays) {

		   long result = 0;
		   if (businessDays != 0) {
		       boolean isStartOnWorkday = dayOfWeek < 6;
		       long absBusinessDays = Math.abs(businessDays);
		       if (isStartOnWorkday) {
		           int shiftedWorkday = businessDays > 0 ? dayOfWeek : 6 - dayOfWeek;
		           result = absBusinessDays + (absBusinessDays + shiftedWorkday - 1) / 5 * 2;
		       } else {
		           int shiftedWeekend = businessDays > 0 ? dayOfWeek : 13 - dayOfWeek;
		           result = absBusinessDays + (absBusinessDays - 1) / 5 * 2 + (7 - shiftedWeekend);
		       }
		   }
		   return result;
		}

		public List<HistoricalQuote> FetchHistoricData()
		{
		LocalDate startDate = LocalDate.now();
		Date date_sorted = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date_sorted);

		long businessDays = -250;
		LocalDate endDate = startDate.minusDays(getAllDays(startDate.getDayOfWeek().getValue(), businessDays));
		Date date = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		String option1 = null;

		String filePath = "D:\\WorkspaceNew\\IntegratedSpringApplications\\Application_2\\Consumer1\\File.txt";
		       
		   try {
		    BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
		       String lineText = null;
		       while ((lineText = lineReader.readLine()) != null) {
		        list.add(lineText);
		       }
		       
		   lineReader.close();
		       } catch (IOException ex) {
		           System.err.println(ex);
		       }
		 
		   option1 = list.get(0);
		long days = ChronoUnit.DAYS.between(date.toInstant(), date_sorted.toInstant());
		Calendar from = Calendar.getInstance();
		   Calendar to = Calendar.getInstance();
		   to.add(cal1.DATE,-1);
		      from.add(cal1.DATE , - (int)days);
		      String b1 = null;
		if(option1.equalsIgnoreCase("NIFTY"))
		{
		b1 = "^NSEI";
		}
		         
		      try {
		     
		      Stock stock = YahooFinance.get(b1, from, to, Interval.DAILY);
		         history =  stock.getHistory(from, to, Interval.DAILY);
		   }
		     
		      catch (IOException e) {
		       e.printStackTrace();
		       }
		     
		      return history;
		}

		public ArrayList<String> RespectiveDates()
		{
		List<HistoricalQuote> historicalQuotes = FetchHistoricData();
		for (HistoricalQuote historicalQuote : historicalQuotes)
		      {
		if(historicalQuote.getClose()!=null)
		{
		ClosingPrice.add(historicalQuote.getClose());
		           Calendar d= historicalQuote.getDate();
		           SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		           String formatted = format1.format(d.getTime());
		           dates.add(formatted);
		}

		      }
		LOGGER.info("DATES FETCHED!");
		      return dates;
		}

		public ArrayList<BigDecimal> ClosingPrice()
		{
		ClosingPrice.clear();
		List<HistoricalQuote> historicalQuotes = FetchHistoricData();
		for (HistoricalQuote historicalQuote : historicalQuotes)
		      {
		if(historicalQuote.getClose()!=null)
		{
		ClosingPrice.add(historicalQuote.getClose());
		}

		      }
		LOGGER.info("CLOSING PRICE FETCHED");
		      return ClosingPrice;
		}
}
