package by.wadikk.core.repositoryJPA;

import by.wadikk.persistence.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoryJpa extends JpaRepository<Category, Long> {


}
