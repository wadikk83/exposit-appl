package by.wadikk.core;

import by.wadikk.core.aspect.ProfileExecutionAspect;
import by.wadikk.core.mapper.ArticleMapper;
import by.wadikk.core.repository.repositoryDTO.ArticleRepositoryDTO;
import by.wadikk.core.repository.repositoryDTO.ProductRepositoryDTO;
import by.wadikk.core.repository.repositoryDTO.StoreRepositoryDTO;
import by.wadikk.core.repository.repositoryDTO.UserRepositoryDTO;
import by.wadikk.core.repository.repositoryJPA.ArticleRepositoryJpa;
import by.wadikk.core.repository.repositoryJPA.ProductRepositoryJpa;
import by.wadikk.core.repository.repositoryJPA.StoreRepositoryJpa;
import by.wadikk.core.repository.repositoryJPA.UserRepositoryJpa;
import by.wadikk.core.service.ArticleService;
import by.wadikk.core.service.ProductService;
import by.wadikk.core.service.StoreService;
import by.wadikk.core.service.UserService;
import by.wadikk.core.service.implDTO.ArticleServiceImplDTO;
import by.wadikk.core.service.implDTO.ProductServiceImplDTO;
import by.wadikk.core.service.implDTO.StoreServiceImplDTO;
import by.wadikk.core.service.implDTO.UserServiceImplDAO;
import by.wadikk.core.service.implJpa.ArticleServiceImplJPA;
import by.wadikk.core.service.implJpa.ProductServiceImplJPA;
import by.wadikk.core.service.implJpa.StoreServiceImplJPA;
import by.wadikk.core.service.implJpa.UserServiceImplJPA;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

    @Value("${datasource.file.format}")
    private String datasourceFileFormat;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Autowired
    private Environment environment;

    /*@Bean
    public UserService userService(UserRepositoryJpa userRepositoryJpa, UserRepositoryDTO userRepositoryDAO) {
        if (datasourceTypeJPA.equals("true")) {
            return new UserServiceImplJPA(userRepositoryJpa);
        } else return new UserServiceImplDAO(userRepositoryDAO);
    }*/

    /*@Bean
    public ProductService productService(ProductRepositoryJpa productRepositoryJpa,
                                         ProductRepositoryDTO productRepositoryDAO) {
        if (datasourceTypeJPA.equals("true")) {
            return new ProductServiceImplJPA(productRepositoryJpa);
        } else return new ProductServiceImplDTO(productRepositoryDAO) ;
    }*/

    /*@Bean
    public ArticleService articleService(ArticleRepositoryJpa articleRepositoryJpa,
                                         ArticleMapper articleMapper,
                                         ArticleRepositoryDTO articleRepositoryDAO) {
        if (datasourceTypeJPA.equals("true")) {
            return new ArticleServiceImplJPA(articleRepositoryJpa, articleMapper);
        } else return new ArticleServiceImplDTO(articleRepositoryDAO);
    }*/
    @Bean
    public StoreService storeService(StoreRepositoryJpa storeRepositoryJpa,
                                     StoreRepositoryDTO storeRepositoryDAO) {
        if (datasourceTypeJPA.equals("true")) {
            return new StoreServiceImplJPA(storeRepositoryJpa);
        } else return new StoreServiceImplDTO(storeRepositoryDAO);
    }

    @Bean
    public ProfileExecutionAspect profileExecutionAspect() {

        return new ProfileExecutionAspect(environment.getActiveProfiles());
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        return mapper;
    }

}
