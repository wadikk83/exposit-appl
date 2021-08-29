package by.wadikk.core.repository.repositoryJPA;

import by.wadikk.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByLogin(String login);
}
