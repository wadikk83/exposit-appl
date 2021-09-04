package by.wadikk.core.service.implDTO;

import by.wadikk.core.repository.repositoryDTO.CategoryRepositoryDTO;
import by.wadikk.core.service.CategoryService;
import by.wadikk.core.service.common.CommonServiceImplDTO;
import by.wadikk.persistence.dto.CategoryDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "datasource.type.JPA", havingValue = "false")
public class CategoryServiceImplDTO extends CommonServiceImplDTO<CategoryDto, CategoryRepositoryDTO>
        implements CategoryService {
    public CategoryServiceImplDTO(CategoryRepositoryDTO repository) {
        super(repository);
    }
}
