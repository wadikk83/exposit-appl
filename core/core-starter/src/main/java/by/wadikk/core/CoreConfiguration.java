package by.wadikk.core;

import by.wadikk.core.aspect.ProfileExecutionAspect;
import by.wadikk.core.service.UserService;
import by.wadikk.core.service.impl.UserServiceImpl;
import by.wadikk.core.service.implJpa.UserServiceJpaImpl;
import by.wadikk.persistence.dao.UserRepositoryDao;
import by.wadikk.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
@ConditionalOnClass
@EnableAspectJAutoProxy
public class CoreConfiguration {

    @Value("${datasource.type.JPA}")
    private String datasourceTypeJPA;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Autowired
    private Environment environment;

    @Bean
    public UserService userService(UserRepository userRepositoryJpa, UserRepositoryDao userRepositoryDao) {
        if (datasourceTypeJPA.equals("true")) {
            return new UserServiceJpaImpl(userRepositoryJpa);
        } else return new UserServiceImpl(userRepositoryDao);
    }

//    @Bean
//    public ProfileExecutionAspect profileExecutionAspect() {
//        return new ProfileExecutionAspect(activeProfile);
//    }

    @Bean
    public ProfileExecutionAspect profileExecutionAspect() {

        return new ProfileExecutionAspect(environment.getActiveProfiles());
    }

}
