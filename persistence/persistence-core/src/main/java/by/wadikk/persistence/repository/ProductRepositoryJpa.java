package by.wadikk.persistence.repository;

import by.wadikk.persistence.entities.Article;
import by.wadikk.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepositoryJpa extends JpaRepository<Product, Long> {

    /*List<Product> findProductsByProductAttributes(long attributeId);

    List<Product> findProductByArticleListIn(List<Article> articleList);*/

}
