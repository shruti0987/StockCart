
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import model.User;
import repository.SavedStocksRepository;
import repository.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "controller", "service", "repository", "config" })
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackageClasses = { SavedStocksRepository.class, UserRepository.class})
@EnableAutoConfiguration

public class Demo3Application {
	
	@Bean
	CommandLineRunner loadData(UserRepository repository) {
		return args -> {
			repository.deleteAll();
			repository.save(new User("Hemlata", "Borana", "hemlata", "hemlata"));
			repository.save(new User("Anjali", "Gaikwad", "anjali", "anjali"));
			repository.save(new User("Esha", "Chiplunkar", "esha", "esha"));
			repository.save(new User("Radha", "Kulkarni", "radha", "radha"));
			repository.save(new User("Shreya", "Pandey", "shreya", "shreya"));
			repository.save(new User("Shruti", "Shukla", "shruti", "shruti"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}

}
