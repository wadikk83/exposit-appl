package by.wadikk.core.repositoryDTO;

import by.wadikk.core.repositoryDTO.common.AbstractRepositoryDAO;
import by.wadikk.persistence.PersistenceConfiguration;
import by.wadikk.persistence.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryDAO extends AbstractRepositoryDAO<User> {

    public UserRepositoryDAO() {
        super(PersistenceConfiguration.USER_CLASS_NAME);
    }
}
