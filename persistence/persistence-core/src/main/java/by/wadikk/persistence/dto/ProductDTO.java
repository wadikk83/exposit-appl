package by.wadikk.persistence.dto;

import by.wadikk.persistence.entities.Article;
import by.wadikk.persistence.entities.Category;
import by.wadikk.persistence.entities.ProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private List<Category> categories;
    private List<ProductAttribute> productAttributeEntities;
    private List<Article> articleList;
}
