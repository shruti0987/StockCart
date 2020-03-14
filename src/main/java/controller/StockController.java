package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repository.StockRepository;
// https://www.javaguides.net/2020/01/spring-boot-hibernate-oracle-crud-example.html
@RestController
@RequestMapping("/api/Stock")
public class StockController {

	@Autowired StockRepository stockRepo;
}
