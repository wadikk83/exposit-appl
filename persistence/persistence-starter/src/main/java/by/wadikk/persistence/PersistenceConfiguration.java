package by.wadikk.persistence;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

@ComponentScan
@EnableJpaRepositories
@EntityScan
@EnableTransactionManagement
//@AutoConfigureBefore({CoreConfiguration.class})
public class PersistenceConfiguration {
}
