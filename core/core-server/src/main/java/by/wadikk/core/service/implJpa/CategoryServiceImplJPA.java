package by.wadikk.core.service.implJpa;

import by.wadikk.core.mapper.Mapper;
import by.wadikk.core.repository.repositoryJPA.CategoryRepositoryJpa;
import by.wadikk.core.service.CategoryService;
import by.wadikk.core.service.common.CommonServiceImplJPA;
import by.wadikk.persistence.dto.CategoryDto;
import by.wadikk.persistence.entities.Category;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@ConditionalOnProperty(name = "datasource.type.JPA", havingValue = "true")
@Service
public class CategoryServiceImplJPA extends CommonServiceImplJPA<CategoryDto, Category, CategoryRepositoryJpa>
        implements CategoryService {
    public CategoryServiceImplJPA(CategoryRepositoryJpa repository, Mapper<Category, CategoryDto> mapper) {
        super(repository, mapper);
    }
}
