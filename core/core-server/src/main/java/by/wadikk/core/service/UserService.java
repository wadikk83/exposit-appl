package by.wadikk.core.service;

import by.wadikk.core.dao.UserDao;
import by.wadikk.core.service.common.AbstractService;
import by.wadikk.persistence.entities.User;
import by.wadikk.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserRepository> {

    public UserService(UserRepository repository, UserDao userDao) {
        super(repository);
    }
}
