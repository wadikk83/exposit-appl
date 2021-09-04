package by.wadikk.core.repository.repositoryJPA;

import by.wadikk.persistence.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepositoryJpa extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {
}
