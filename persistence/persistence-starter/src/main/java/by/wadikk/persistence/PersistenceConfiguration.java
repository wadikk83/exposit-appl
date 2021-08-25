package by.wadikk.persistence;


import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
@ComponentScan
@EnableJpaRepositories
@EntityScan
@EnableTransactionManagement
@PropertySource("classpath:persistence.properties")
@PropertySource("classpath:liquibase.properties")
@ConditionalOnClass
public class PersistenceConfiguration {

    public static final String USER_CLASS_NAME = "UserDao";
    public static final String PRODUCT_CLASS_NAME = "ProductDao";
    public static final String CATEGORY_CLASS_NAME = "CategoryDao";

    public static String fileDirectory;
    public static String datasourceFileFormat;

    @Resource
    public Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConf() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean("appDataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));

        fileDirectory = environment.getRequiredProperty("datasource.file.directory");
        datasourceFileFormat = environment.getRequiredProperty("datasource.file.format");
        return dataSource;
    }

}
