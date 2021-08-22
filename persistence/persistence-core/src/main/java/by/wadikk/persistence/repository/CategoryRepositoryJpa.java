package by.wadikk.persistence.repository;

import by.wadikk.persistence.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositoryJpa extends JpaRepository<Category, Long> {


}
