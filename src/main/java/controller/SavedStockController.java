package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import model.RStock;
import model.SavedStocks;
import service.SavedStocksService;

@RestController
@RequestMapping("/saved_stocks")
@Api(value = "saved stocks controller")
@Component
public class SavedStockController {

	@Autowired
	private SavedStocksService service;

	public void saveStock(long user_id,RStock s) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		SavedStocks stock = new SavedStocks(user_id, dtf.format(now), s);
		service.saveStock(stock);
	}

}
