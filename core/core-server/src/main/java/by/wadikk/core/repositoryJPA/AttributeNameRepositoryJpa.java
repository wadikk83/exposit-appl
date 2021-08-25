package by.wadikk.core.repositoryJPA;

import by.wadikk.persistence.entities.AttributeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeNameRepositoryJpa extends JpaRepository<AttributeName, Long> {
}
