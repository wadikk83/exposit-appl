package by.wadikk.persistence;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;

@Configuration
@ConditionalOnClass
public class LiquibaseConfigurer {

    @Autowired
    @Qualifier(value = "appDataSource")
    private DataSource oltpDataSource;


    @Bean
    @DependsOn
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        //liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.xml");
        liquibase.setChangeLog("db/changelog/db.changelog-master.xml");
        liquibase.setDataSource(oltpDataSource);
        return liquibase;
    }
}