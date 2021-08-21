package by.wadikk.persistence.repository;

import by.wadikk.persistence.entities.User;
import by.wadikk.persistence.repository.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CommonRepository<User> {
}
