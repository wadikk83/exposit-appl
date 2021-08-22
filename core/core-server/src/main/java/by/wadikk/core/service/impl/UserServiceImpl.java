package by.wadikk.core.service.impl;

import by.wadikk.core.service.UserService;
import by.wadikk.persistence.dao.UserRepositoryDao;
import by.wadikk.persistence.entities.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepositoryDao userRepository;

    public UserServiceImpl(UserRepositoryDao userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public List<User> saveAll(List<User> entities) {
        for (User user : entities) {
            save(user);
        }
        return getAll();
    }

    @Override
    public Optional<User> update(User entity, Long id) {
        entity.setId(id);
        return userRepository.update(entity);
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.get(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public Boolean deleteById(Long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public Boolean deleteAll() {
        return userRepository.deleteAll();
    }
}
