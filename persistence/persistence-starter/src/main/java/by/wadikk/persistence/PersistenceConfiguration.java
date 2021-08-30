package by.wadikk.persistence;


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

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"by.wadikk.persistence"})
@EnableJpaRepositories
@EntityScan
@EnableTransactionManagement
@PropertySource("classpath:persistence.properties")
@PropertySource("classpath:liquibase.properties")
public class PersistenceConfiguration {

    public static String fileDirectory;

    public static String USER_CLASS_NAME;
    public static String PRODUCT_CLASS_NAME;
    public static String CATEGORY_CLASS_NAME;
    public static String ARTICLE_CLASS_NAME;
    public static String STORE_CLASS_NAME;

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


    @PostConstruct
    public void initialise() {
        USER_CLASS_NAME = fileDirectory + "UserDao";
        PRODUCT_CLASS_NAME = fileDirectory + "ProductDao";
        CATEGORY_CLASS_NAME = fileDirectory + "CategoryDao";
        ARTICLE_CLASS_NAME = fileDirectory + "ArticleDao";
        STORE_CLASS_NAME = fileDirectory + "StoreDao";

    }
}
