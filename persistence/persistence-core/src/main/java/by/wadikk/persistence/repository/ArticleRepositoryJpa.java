package by.wadikk.persistence.repository;

import by.wadikk.persistence.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepositoryJpa extends JpaRepository<Article, Long> {

    List<Article> findArticleByStore(Long storeId);
}
