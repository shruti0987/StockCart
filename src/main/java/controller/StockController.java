package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.Stock;
import service.StockService;

// https://www.javaguides.net/2020/01/spring-boot-hibernate-oracle-crud-example.html
@RestController
@RequestMapping("/Stock")
@Api(tags = "{stocks}")
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
	public Stock getStockById(long id)
	{
		return stockService.getStock(id).orElseThrow(); //add exception
	}
}
