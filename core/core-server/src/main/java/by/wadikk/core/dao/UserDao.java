package by.wadikk.core.dao;

import by.wadikk.core.CoreConfiguration;
import by.wadikk.core.dao.common.AbstractDao;
import by.wadikk.persistence.entities.User;

public class UserDao extends AbstractDao<User> {
    public UserDao() {
        super(CoreConfiguration.USER_CLASS_NAME);
    }


}
