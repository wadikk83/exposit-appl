package by.wadikk.core.mapper;

import by.wadikk.persistence.dto.UserDto;
import by.wadikk.persistence.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDto>{
    @Autowired
    public UserMapper() {
        super(User.class, UserDto.class);
    }
}
