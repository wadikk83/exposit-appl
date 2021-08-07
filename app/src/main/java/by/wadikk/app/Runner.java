package by.wadikk.app;

import by.wadikk.core.model.User;
import by.wadikk.core.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan({"by.wadikk"})
@EntityScan(basePackages = "by.wadikk.core.model")
@EnableJpaRepositories(basePackages = "by.wadikk")
public class Runner implements InitializingBean {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class);
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        userRepository.save(new User("admin", "admin", "admin"));
    }
}
