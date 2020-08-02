package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//https://dzone.com/articles/spring-boot-2-restful-api-documentation-with-swagg
@Configuration
@EnableSwagger2
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("controller"))              
          .paths(PathSelectors.regex("/.*"))                          
          .build().apiInfo(apiInfo());                                        
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Springfox Stockcart API")
            .description("Find and save top stocks!")
            .version("1.0")
            .build();
    }
    
}