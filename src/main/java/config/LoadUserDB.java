package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import model.User;
import repository.UserRepository;


@Configuration
@Slf4j
public class LoadUserDB {
	@Bean
	CommandLineRunner initDatabase(UserRepository repository)
	{
		Logger logger = LoggerFactory.getLogger("Users");
		return args -> {
			logger.info("Preloading "+repository.save(new User("Shruti","Shukla","shruti","shruti")));
			logger.info("Preloading "+repository.save(new User("Shreya","Pandey","shreya","shreya")));
		};
	}
}
