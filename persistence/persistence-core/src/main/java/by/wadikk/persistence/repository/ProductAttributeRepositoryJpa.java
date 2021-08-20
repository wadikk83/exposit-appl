package by.wadikk.persistence.repository;

import by.wadikk.persistence.entities.ProductAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepositoryJpa extends JpaRepository<ProductAttributeEntity, Long> {
}
