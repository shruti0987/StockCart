package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Stock;
import repository.StockRepository;
// https://www.javaguides.net/2020/01/spring-boot-hibernate-oracle-crud-example.html
@RestController
@RequestMapping("/api/Stock")
public class StockController {

	@Autowired StockRepository stockRepo;
	
	@GetMapping("/api/Stock/stocks")
	public List<Stock> getStocks()
	{
		return stockRepo.findAll();
	}
	
	@GetMapping("/api/Stock/stocks/{id}")
	public Stock getStockById(long id)
	{
		return stockRepo.findById(id).orElseThrow(); //add exception
	}
}
