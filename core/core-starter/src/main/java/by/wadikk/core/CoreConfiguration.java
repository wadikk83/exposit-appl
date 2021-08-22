package by.wadikk.core;


import by.wadikk.core.service.UserService;
import by.wadikk.core.service.impl.UserServiceImpl;
import by.wadikk.core.service.implJpa.UserServiceJpaImpl;
import by.wadikk.persistence.dao.UserRepositoryDao;
import by.wadikk.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ConditionalOnClass
public class CoreConfiguration {

    @Value("${datasource.type.JPA}")
    private String datasourceTypeJPA;

    @Bean
    public UserService userService(UserRepository userRepositoryJpa, UserRepositoryDao userRepositoryDao) {
        if (datasourceTypeJPA.equals("true")) {
            return new UserServiceJpaImpl(userRepositoryJpa);
        } else return new UserServiceImpl(userRepositoryDao);
    }


}
