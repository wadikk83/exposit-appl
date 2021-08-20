package by.wadikk.persistence.repository;

import by.wadikk.persistence.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepositoryJpa extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findArticleByStore(Long storeId);
}
