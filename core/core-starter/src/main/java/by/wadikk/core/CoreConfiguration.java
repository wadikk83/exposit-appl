package by.wadikk.core;

import by.wadikk.core.aspect.ProfileExecutionAspect;
import by.wadikk.core.repositoryDTO.ProductRepositoryDAO;
import by.wadikk.core.repositoryDTO.UserRepositoryDAO;
import by.wadikk.core.repositoryJPA.ProductRepositoryJpa;
import by.wadikk.core.repositoryJPA.UserRepositoryJpa;
import by.wadikk.core.service.ProductService;
import by.wadikk.core.service.UserService;
import by.wadikk.core.service.implDAO.ProductServiceImplDAO;
import by.wadikk.core.service.implDAO.UserServiceImplDAO;
import by.wadikk.core.service.implJpa.ProductServiceImplJPA;
import by.wadikk.core.service.implJpa.UserServiceImplJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"by.wadikk.core"})
@ConditionalOnClass
@EnableAspectJAutoProxy
@EnableJpaRepositories
public class CoreConfiguration {

    @Value("${datasource.type.JPA}")
    private String datasourceTypeJPA;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Autowired
    private Environment environment;

    @Bean
    public UserService userService(UserRepositoryJpa userRepositoryJpa, UserRepositoryDAO userRepositoryDAO) {
        if (datasourceTypeJPA.equals("true")) {
            return new UserServiceImplJPA(userRepositoryJpa);
        } else return new UserServiceImplDAO(userRepositoryDAO);
    }

    @Bean
    public ProductService productService(ProductRepositoryJpa productRepositoryJpa, ProductRepositoryDAO productRepositoryDAO) {
        if (datasourceTypeJPA.equals("true")) {
            return new ProductServiceImplJPA(productRepositoryJpa);
        } else return new ProductServiceImplDAO(productRepositoryDAO);
    }

    @Bean
    public ProfileExecutionAspect profileExecutionAspect() {

        return new ProfileExecutionAspect(environment.getActiveProfiles());
    }

}
