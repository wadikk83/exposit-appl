package by.wadikk.core.mapper;

import by.wadikk.core.repository.repositoryJPA.ArticleRepositoryJpa;
import by.wadikk.persistence.dto.ProductDto;
import by.wadikk.persistence.entities.Article;
import by.wadikk.persistence.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper extends AbstractMapper<Product, ProductDto> {

//    private List<CategoryDto> categories;
//    private List<ProductAttributeDto> productAttribute;
//    private List<ArticleDto> articleList;

    private final ModelMapper mapper;
    private final ArticleRepositoryJpa articleRepository;

    @Autowired
    public ProductMapper(ModelMapper mapper, ArticleRepositoryJpa articleRepository) {
        super(Product.class, ProductDto.class);
        this.mapper = mapper;
        this.articleRepository = articleRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Product.class, ProductDto.class)
                .addMappings(m -> m.skip(ProductDto::setArticleId)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(ProductDto.class, Product.class)
                .addMappings(m -> m.skip(Product::setArticleList)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(Product source, ProductDto destination) {
        destination.setArticleId(getArticleList(source));
    }

    @Override
    void mapSpecificFields(ProductDto source, Product destination) {
        destination.setArticleList(getArticleEntity(source.getArticleId()));
    }

    private List<Article> getArticleEntity(List<Long> sourceList) {
        return sourceList.stream()
                .map((e) -> articleRepository.getById(e))
                .collect(Collectors.toList());
    }

    private List<Long> getArticleList(Product source) {
        return source.getArticleList().stream()
                .map((e) -> e.getId())
                .collect(Collectors.toList());

    }
}
