package by.wadikk.core.service.impl;

import by.wadikk.core.model.User;
import by.wadikk.core.repository.UserRepository;
import by.wadikk.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User addNewUser(String login, String password, String email) {
        User user = new User(login, password, email);
        return userRepository.save(user);
    }
}
