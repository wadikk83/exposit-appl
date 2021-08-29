package by.wadikk.core.service.implJpa;

import by.wadikk.core.base.ErrorType;
import by.wadikk.core.exception.EntityException;
import by.wadikk.core.mapper.ObjectMapper;
import by.wadikk.core.repository.repositoryJPA.UserRepositoryJpa;
import by.wadikk.core.service.UserService;
import by.wadikk.persistence.dto.UserDto;
import by.wadikk.persistence.entities.User;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class UserServiceImplJPA implements UserService {

    private final UserRepositoryJpa userRepository;

    @Autowired
    private final ObjectMapper objectMapper;

    @Autowired
    public UserServiceImplJPA(UserRepositoryJpa userRepository) {
        this.userRepository = userRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Optional<UserDto> save(UserDto userDto) {
        User entity = objectMapper.map(userDto, User.class);
        entity = userRepository.save(entity);
        return Optional.of(objectMapper.map(entity, UserDto.class));
    }

    @Override
    public Optional<UserDto> update(UserDto entity, Long id) {
        entity.setId(id);
        return save(entity);
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        UserDto userDto = objectMapper.map(userRepository.findById(id).get(), UserDto.class);
        return Optional.of(userDto);
    }

    @Override
    public List<UserDto> getAll() {
        return objectMapper.mapAll(userRepository.findAll(), UserDto.class);
    }

    @Override
    public Boolean deleteById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new EntityException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));
        userRepository.deleteById(id);
        return !userRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        userRepository.deleteAll();
        return Lists.newArrayList(userRepository.findAll()).isEmpty();
    }
}
