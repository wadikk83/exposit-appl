package by.wadikk.core.repository.repositoryJPA;

import by.wadikk.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepositoryJpa extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
