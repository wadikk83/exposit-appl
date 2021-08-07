package by.wadikk.core.service;

import by.wadikk.core.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getByLogin(String login);

    void deleteUser(Long id);

    User addNewUser(String login, String password, String email);
}
