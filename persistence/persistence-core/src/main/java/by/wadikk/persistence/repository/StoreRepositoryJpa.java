package by.wadikk.persistence.repository;

import by.wadikk.persistence.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepositoryJpa extends JpaRepository<Store, Long> {
}
