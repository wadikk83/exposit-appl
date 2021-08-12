package by.wadikk.core.repository;

import by.wadikk.core.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findArticleByStore(Long storeId);
}
