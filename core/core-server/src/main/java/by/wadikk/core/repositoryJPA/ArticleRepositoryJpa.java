package by.wadikk.core.repositoryJPA;

import by.wadikk.persistence.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepositoryJpa extends JpaRepository<Article, Long> {

    List<Article> findArticleByStore(Long storeId);
}
