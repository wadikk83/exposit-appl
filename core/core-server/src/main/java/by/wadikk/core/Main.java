package by.wadikk.core;

import by.wadikk.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Main implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.addNewUser("admin","admin","admin");
    }
}
