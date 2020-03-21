package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import model.Stock;
import repository.StockRepository;


@Configuration
@Slf4j
public class LoadStockDB {
	@Bean
	CommandLineRunner initDatabase(StockRepository repository)
	{
		Logger logger = LoggerFactory.getLogger("Stocks");
		return args -> {
			logger.info("Preloading "+repository.save(new Stock("Mahindra","Automobile",12,4)));
			logger.info("Preloading "+repository.save(new Stock("TCS","IT",20,2)));
		};
	}
}
