package by.wadikk.core.repositoryJPA;

import by.wadikk.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface ProductRepositoryJpa extends JpaRepository<Product, Long> {

}
