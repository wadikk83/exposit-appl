package by.wadikk.core.repository;

import by.wadikk.core.model.Article;
import by.wadikk.core.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByProductAttributes(long attributeId);

    List<Product> findProductByArticleListIn(List<Article> articleList);

}
