package by.wadikk.persistence.repository;

import by.wadikk.persistence.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositoryJpa extends JpaRepository<CategoryEntity, Long> {


}
