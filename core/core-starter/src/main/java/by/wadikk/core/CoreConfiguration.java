package by.wadikk.core;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan({"by.wadikk"})
public class CoreConfiguration {

    private Environment environment;


    @Bean
    public void Test(){
        String bbb = environment.getProperty("datasource.file.format");

    }

}
