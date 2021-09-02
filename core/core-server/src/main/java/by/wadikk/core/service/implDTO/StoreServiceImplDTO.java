package by.wadikk.core.service.implDTO;

import by.wadikk.core.repository.repositoryDTO.StoreRepositoryDTO;
import by.wadikk.core.service.StoreService;
import by.wadikk.core.service.common.CommonServiceImplDTO;
import by.wadikk.persistence.dto.StoreDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "datasource.type.JPA", havingValue = "false")
public class StoreServiceImplDTO extends CommonServiceImplDTO<StoreDto, StoreRepositoryDTO>
        implements StoreService {

    public StoreServiceImplDTO(StoreRepositoryDTO repository) {
        super(repository);
    }
}