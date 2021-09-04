package by.wadikk.core.repository.repositoryJPA;

import by.wadikk.persistence.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoryJpa extends JpaRepository<Category, Long> {
}