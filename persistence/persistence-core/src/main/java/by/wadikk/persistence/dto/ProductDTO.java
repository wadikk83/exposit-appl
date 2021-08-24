package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Article;
import by.wadikk.persistence.entities.Category;
import by.wadikk.persistence.entities.ProductAttribute;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private List<Category> categories;
    private List<ProductAttribute> productAttributeEntities;
    private List<Article> articleList;
}
