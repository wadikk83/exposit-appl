package by.wadikk.persistence.dao;

import by.wadikk.persistence.PersistenceConfiguration;
import by.wadikk.persistence.dao.common.AbstractRepositoryDao;
import by.wadikk.persistence.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryDao extends AbstractRepositoryDao<User> {

    public UserRepositoryDao() {
        super(PersistenceConfiguration.USER_CLASS_NAME);
    }
}
