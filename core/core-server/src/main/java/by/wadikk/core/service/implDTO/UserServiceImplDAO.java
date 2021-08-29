package by.wadikk.core.service.implDTO;

import by.wadikk.core.repository.repositoryDTO.UserRepositoryDTO;
import by.wadikk.core.service.UserService;
import by.wadikk.persistence.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


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

}
