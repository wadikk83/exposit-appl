package by.wadikk.core.repository.repositoryJPA;

import by.wadikk.persistence.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepositoryJpa extends JpaRepository<Store, Long> {
}
