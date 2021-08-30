package by.wadikk.loader;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"by.wadikk.loader"})
@ConfigurationPropertiesScan("by.wadikk.loader")
@ConditionalOnProperty(prefix = "loader", name = "enabled", havingValue = "true")
public class LoaderConfiguration {

}
