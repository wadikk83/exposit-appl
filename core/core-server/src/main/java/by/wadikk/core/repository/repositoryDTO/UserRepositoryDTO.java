package by.wadikk.core.repository.repositoryDTO;

import by.wadikk.core.repository.repositoryDTO.common.AbstractRepositoryDTO;
import by.wadikk.persistence.PersistenceConfiguration;
import by.wadikk.persistence.dto.UserDto;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryDTO extends AbstractRepositoryDTO<UserDto> {

    public UserRepositoryDTO() {
        super(PersistenceConfiguration.USER_CLASS_NAME);
    }
}
