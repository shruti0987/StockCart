


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import model.User;
import repository.StockRepository;
import repository.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"controller","service","repository","config"})
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackageClasses = {StockRepository.class,UserRepository.class})
@EnableAutoConfiguration //(exclude = {DataSourceAutoConfiguration.class })

public class Demo3Application{

	@Bean
	CommandLineRunner initData(UserRepository repository){
	  return args -> {
      repository.save(new User("Shruti","Shukla","shruti","shruti"));
      repository.save(new User("Shreya","Pandey","shreya","shreya"));
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
