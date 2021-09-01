package by.wadikk.core.service;

import by.wadikk.core.service.common.CommonService;
import by.wadikk.persistence.dto.UserDto;
import by.wadikk.persistence.entities.User;
import com.sun.istack.Nullable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


public interface UserService extends CommonService<UserDto> {

    List<UserDto> findAll(Specification<User> userSpecification);

}
