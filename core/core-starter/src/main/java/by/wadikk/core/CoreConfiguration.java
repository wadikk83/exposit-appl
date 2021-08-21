package by.wadikk.core;


import by.wadikk.core.dao.UserDao;
import by.wadikk.core.service.UserService;
import by.wadikk.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CoreConfiguration {

    public static final String USER_CLASS_NAME = "UserDao";
    public static final String PRODUCT_CLASS_NAME = "ProductDao";
    public static final String CATEGORY_CLASS_NAME = "CategoryDao";

    @Value("${datasource.type.JPA}")
    private String dataSource;

    /*@Bean
    public UserService userService() {
        if (dataSource.equals("true")) {
            return new UserRepository();
        }
        return new UserDao();

    }*/

}
