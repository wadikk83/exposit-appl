package by.wadikk.core.service.implDTO;

import by.wadikk.core.repository.repositoryDTO.UserRepositoryDTO;
import by.wadikk.core.service.UserService;
import by.wadikk.persistence.dto.UserDto;
import by.wadikk.persistence.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ConditionalOnProperty(name = "datasource.type.JPA", havingValue = "false")
public class UserServiceImplDAO implements UserService {

    private final UserRepositoryDTO repository;

    @Autowired
    public UserServiceImplDAO(UserRepositoryDTO userRepository) {
        this.repository = userRepository;
    }

    @Override
    public Optional<UserDto> save(UserDto userDto) {
        return repository.save(userDto);
    }

    @Override
    public Optional<UserDto> update(UserDto entity, Long id) {
        return repository.update(entity);
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        return repository.get(id);
    }

    @Override
    public List<UserDto> getAll() {
        return repository.getAll();
    }

    @Override
    public Boolean deleteById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public Boolean deleteAll() {
        return repository.deleteAll();
    }

    @Override
    public List<UserDto> findAll(Specification<User> userSpecification) {
        return new ArrayList<UserDto>();
    }
}
