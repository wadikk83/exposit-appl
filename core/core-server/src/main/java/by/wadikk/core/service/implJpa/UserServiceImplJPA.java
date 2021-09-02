package by.wadikk.core.service.implJpa;

import by.wadikk.core.mapper.Mapper;
import by.wadikk.core.mapper.UserMapper;
import by.wadikk.core.repository.repositoryJPA.UserRepositoryJpa;
import by.wadikk.core.service.UserService;
import by.wadikk.core.service.common.CommonServiceImplJPA;
import by.wadikk.persistence.dto.UserDto;
import by.wadikk.persistence.entities.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ConditionalOnProperty(name = "datasource.type.JPA", havingValue = "true")
@Service
public class UserServiceImplJPA extends CommonServiceImplJPA<UserDto, User, UserRepositoryJpa>
        implements UserService {


    public UserServiceImplJPA(UserRepositoryJpa repository, Mapper<User, UserDto> mapper) {
        super(repository, mapper);
    }

    @Override
    public List<UserDto> findAll(Specification<User> userSpecification) {
        return repository.findAll(userSpecification).stream()
                .map(entity -> mapper.toDto(entity))
                .collect(Collectors.toList());
    }
}