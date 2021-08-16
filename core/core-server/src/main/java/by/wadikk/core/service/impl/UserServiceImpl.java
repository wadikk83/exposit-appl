package by.wadikk.core.service.impl;

import by.wadikk.core.model.User;
import by.wadikk.core.repository.UserRepository;
import by.wadikk.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean create(User user) {
        if (userRepository.findById(user.getId()) == null) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user, long id) {
        User oldUser = userRepository.findById(id).get();
        oldUser.setLogin(user.getLogin());
        oldUser.setPassword(user.getPassword());
        oldUser.setFullName(user.getFullName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        return userRepository.save(oldUser);
    }

    @Override
    public boolean delete(long id) {
        if (userRepository.findById(id) != null) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
