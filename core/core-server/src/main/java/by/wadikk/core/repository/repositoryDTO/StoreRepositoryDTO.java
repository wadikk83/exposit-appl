package by.wadikk.core.repository.repositoryDTO;

import by.wadikk.core.repository.repositoryDTO.common.AbstractRepositoryDTO;
import by.wadikk.persistence.PersistenceConfiguration;
import by.wadikk.persistence.dto.StoreDto;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRepositoryDTO extends AbstractRepositoryDTO<StoreDto> {
    public StoreRepositoryDTO() {
        super(PersistenceConfiguration.STORE_CLASS_NAME);
    }
}