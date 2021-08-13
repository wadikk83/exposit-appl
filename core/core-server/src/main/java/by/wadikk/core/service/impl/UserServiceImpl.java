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
        log.debug("Read all user");
        return userRepository.findAll();
    }

    @Override
    public User read(long id) {
        return userRepository.getById(id);
    }

    @Override
    public boolean update(User user, long id) {
        if (userRepository.getById(id) != null) {
            userRepository.save(user);
            return true;
        }
        return false;
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
