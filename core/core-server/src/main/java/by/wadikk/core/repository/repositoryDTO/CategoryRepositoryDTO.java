package by.wadikk.core.repository.repositoryDTO;

import by.wadikk.core.repository.repositoryDTO.common.AbstractRepositoryDTO;
import by.wadikk.persistence.PersistenceConfiguration;
import by.wadikk.persistence.dto.CategoryDto;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryDTO extends AbstractRepositoryDTO<CategoryDto> {
    public CategoryRepositoryDTO() {
        super(PersistenceConfiguration.CATEGORY_CLASS_NAME);
    }
}
