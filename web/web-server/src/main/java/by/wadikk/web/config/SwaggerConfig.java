package by.wadikk.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Example Swagger Api")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("wadikk83@gmail.com")
                                                .url("http://exposit.com")
                                                .name("Vadzim Nekhviadovich")
                                )
                );
    }

}