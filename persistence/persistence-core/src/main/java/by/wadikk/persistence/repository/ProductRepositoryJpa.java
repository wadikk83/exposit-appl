package by.wadikk.persistence.repository;

import by.wadikk.persistence.entities.ArticleEntity;
import by.wadikk.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findProductsByProductAttributes(long attributeId);

    List<ProductEntity> findProductByArticleListIn(List<ArticleEntity> articleEntityList);

}
