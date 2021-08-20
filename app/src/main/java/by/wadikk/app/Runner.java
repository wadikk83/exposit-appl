package by.wadikk.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication(scanBasePackages = {
        "by.wadikk",
        "by.wadikk.web.controller",
        "by.wadikk.core"})
@Configuration
@ComponentScan({"by.wadikk"})
@EntityScan(basePackages = "by.wadikk.persistence.model")
@EnableJpaRepositories(basePackages = "by.wadikk")
@Slf4j
public class Runner implements InitializingBean {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class);
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Add new user {}", new User("admin", "admin", "admin").toString());
        //userRepository.save(new User("admin", "admin", "admin"));
    }
}*/

@SpringBootApplication
public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class);
    }
}
