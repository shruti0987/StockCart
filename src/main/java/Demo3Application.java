


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import model.Sector;
import model.User;
import repository.SectorRepository;
import repository.StockRepository;
import repository.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"controller","service","repository","config"})
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackageClasses = {StockRepository.class,UserRepository.class,SectorRepository.class})
@EnableAutoConfiguration //(exclude = {DataSourceAutoConfiguration.class })

public class Demo3Application{

	@Bean
	CommandLineRunner loadData(UserRepository repository,SectorRepository r){
		  return args -> {
	      repository.save(new User("Shruti","Shukla","shruti","shruti"));
	      repository.save(new User("Shreya","Pandey","shreya","shreya"));
	      repository.save(new User("Radha","Kulkarni","radha","radha"));
	      repository.save(new User("Anjali","Gaikwad","anjali","anjali"));
	      repository.save(new User("Esha","Chiplunkar","esha","esha"));
	      r.save(new Sector("Automobile"));
	      r.save(new Sector("Banking"));
	      r.save(new Sector("Energy - Oil & Gas"));
	      r.save(new Sector("Financial Services"));
	      r.save(new Sector("Information Technology"));

	   };
		}
		
	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}
	

	
}


	/*
	 @Override
	 
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(applicationClass);
	    }*/
