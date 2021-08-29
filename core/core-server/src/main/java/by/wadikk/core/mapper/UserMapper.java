package by.wadikk.core.mapper;

import by.wadikk.persistence.dto.UserDto;
import by.wadikk.persistence.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper extends AbstractMapper<User, UserDto>{
    @Autowired
    UserMapper() {
        super(User.class, UserDto.class);
    }
}
