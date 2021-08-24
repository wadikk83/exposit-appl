package by.wadikk.core.repositoryJPA;

import by.wadikk.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
