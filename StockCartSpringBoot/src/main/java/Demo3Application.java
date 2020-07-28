
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.SavedStocksRepository;
import repository.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "controller", "service", "repository", "config" })
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackageClasses = { SavedStocksRepository.class, UserRepository.class})
@EnableAutoConfiguration

public class Demo3Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}

}
