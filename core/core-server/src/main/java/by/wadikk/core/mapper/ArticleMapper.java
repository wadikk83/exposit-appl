package by.wadikk.core.mapper;

import by.wadikk.core.repository.repositoryJPA.ProductRepositoryJpa;
import by.wadikk.core.repository.repositoryJPA.StoreRepositoryJpa;
import by.wadikk.persistence.dto.ArticleDto;
import by.wadikk.persistence.entities.Article;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;


@Component
public class ArticleMapper extends AbstractMapper<Article, ArticleDto> {

    private final ModelMapper mapper;
    private final StoreRepositoryJpa storeRepository;
    private final ProductRepositoryJpa productRepository;

    @Autowired
    public ArticleMapper(ModelMapper mapper, StoreRepositoryJpa storeRepository, ProductRepositoryJpa productRepository) {
        super(Article.class, ArticleDto.class);
        this.mapper = mapper;
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Article.class, ArticleDto.class)
                .addMappings(m -> m.skip(ArticleDto::setProductId)).setPostConverter(toDtoConverter());
        mapper.typeMap(Article.class, ArticleDto.class)
                .addMappings(m -> m.skip(ArticleDto::setStoreId)).setPostConverter(toDtoConverter());
        /*mapper.createTypeMap(Article.class, ArticleDto.class)
                .addMappings(m -> m.skip(ArticleDto::setStoreId)).setPostConverter(toDtoConverter());*/

        mapper.createTypeMap(ArticleDto.class, Article.class)
                .addMappings(m -> m.skip(Article::setProduct)).setPostConverter(toEntityConverter());
        mapper.typeMap(ArticleDto.class, Article.class)
                .addMappings(m -> m.skip(Article::setStore)).setPostConverter(toEntityConverter());
        /*mapper.createTypeMap(ArticleDto.class, Article.class)
                .addMappings(m -> m.skip(Article::setStore)).setPostConverter(toEntityConverter());*/
    }

    @Override
    void mapSpecificFields(Article source, ArticleDto destination) {
        destination.setProductId(getProductId(source));
        destination.setStoreId(getProductId(source));
    }

    @Override
    void mapSpecificFields(ArticleDto source, Article destination) {
        destination.setProduct(productRepository.findById(source.getProductId()).orElse(null));
        destination.setStore(storeRepository.findById(source.getStoreId()).orElse(null));
    }

    private Long getProductId(Article source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getProduct().getId();
    }

    private Long getStoreId(Article source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getStore().getId();
    }
}
