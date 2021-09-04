package by.wadikk.core.mapper;

import by.wadikk.core.repository.repositoryJPA.CategoryRepositoryJpa;
import by.wadikk.persistence.dto.CategoryDto;
import by.wadikk.persistence.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class CategoryMapper extends AbstractMapper<Category, CategoryDto> {

    private final ModelMapper mapper;
    private final CategoryRepositoryJpa categoryRepository;

    public CategoryMapper(ModelMapper mapper, CategoryRepositoryJpa categoryRepository) {
        super(Category.class, CategoryDto.class);
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
    }


    @PostConstruct
    private void setupMapper() {
        mapper.createTypeMap(Category.class, CategoryDto.class)
                .addMappings(m -> m.skip(CategoryDto::setParentId)).setPostConverter(toDtoConverter());


        mapper.createTypeMap(CategoryDto.class, Category.class)
                .addMappings(m -> m.skip(Category::setParent)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(Category source, CategoryDto destination) {
        destination.setParentId(getCategoryParentId(source));
    }

    @Override
    void mapSpecificFields(CategoryDto source, Category destination) {
        destination.setParent(categoryRepository.findById(source.getParentId()).orElse(null));
    }

    private Long getCategoryParentId(Category source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getId();
    }
}
