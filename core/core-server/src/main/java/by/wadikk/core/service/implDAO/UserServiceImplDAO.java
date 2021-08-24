package by.wadikk.core.service.implDAO;

import by.wadikk.core.annotation.ProfileExecution;
import by.wadikk.core.repositoryDTO.UserRepositoryDAO;
import by.wadikk.core.service.UserService;
import by.wadikk.persistence.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImplDAO implements UserService {

    private final UserRepositoryDAO userRepository;

    @Autowired
    public UserServiceImplDAO(UserRepositoryDAO userRepository) {
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
    @ProfileExecution
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
