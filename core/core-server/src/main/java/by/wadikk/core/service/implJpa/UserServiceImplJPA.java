package by.wadikk.core.service.implJpa;

import by.wadikk.core.annotation.ProfileExecution;
import by.wadikk.core.repositoryJPA.UserRepositoryJpa;
import by.wadikk.core.service.UserService;
import by.wadikk.persistence.base.ErrorType;
import by.wadikk.persistence.entities.User;
import by.wadikk.persistence.exception.SampleException;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class UserServiceImplJPA implements UserService {

    private final UserRepositoryJpa userRepository;

    @Autowired
    public UserServiceImplJPA(UserRepositoryJpa userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> save(User entity) {
        return Optional.of(userRepository.save(entity));
    }

    @Override
    public List<User> saveAll(List<User> entities) {
        return Lists.newArrayList(userRepository.saveAll(entities));
    }

    @Override
    public Optional<User> update(User entity, Long id) {
        entity.setId(id);
        return Optional.of(userRepository.save(entity));
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @ProfileExecution
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean deleteById(Long id) {

        User entity = getById(id)
                .orElseThrow(() -> new SampleException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));
        userRepository.deleteById(id);
        return !userRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        userRepository.deleteAll();
        return Lists.newArrayList(userRepository.findAll()).isEmpty();
    }
}
