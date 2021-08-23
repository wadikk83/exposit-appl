package by.wadikk.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication

public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class);
    }
}
