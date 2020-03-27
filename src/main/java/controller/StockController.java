package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.Stock;
import service.StockService;

// https://www.javaguides.net/2020/01/spring-boot-hibernate-oracle-crud-example.html
@RestController
@RequestMapping("/stock")
@Api(value = "Stocks" )
@Component
public class StockController {

	@Autowired
    private StockService stockService;
	
	
	@GetMapping("/api/Stock/stocks")
	@ApiOperation(value = "Get all stocks.", notes = "Returns a list of all stocks.")
	public List<Stock> getStocks()
	{
		return stockService.getAllStocks();
	}
	
	@GetMapping("/api/Stock/stocks/{id}")
	@ApiOperation(value = "Find stock by id.", notes = "Search for a stock using stock id.")
	public Stock getStockById(long id)
	{
		return stockService.getStock(id).orElseThrow(); //add exception
	}
}
