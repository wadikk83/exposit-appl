package by.wadikk.persistence.repository;

import by.wadikk.persistence.entities.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepositoryJpa extends JpaRepository<StoreEntity, Long> {
}
