package by.wadikk.persistence.repository;

import by.wadikk.persistence.entities.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepositoryJpa extends JpaRepository<ProductAttribute, Long> {
}
