package by.wadikk.core.repositoryJPA;

import by.wadikk.persistence.entities.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeRepositoryJpa extends JpaRepository<ProductAttribute, Long> {
}
