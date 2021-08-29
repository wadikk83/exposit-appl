package by.wadikk.core.service.implDTO;

import by.wadikk.core.repository.repositoryDTO.StoreRepositoryDTO;
import by.wadikk.core.service.StoreService;
import by.wadikk.core.service.common.CommonServiceImplDTO;
import by.wadikk.persistence.dto.StoreDto;

public class StoreServiceImplDTO extends CommonServiceImplDTO<StoreDto, StoreRepositoryDTO>
        implements StoreService {

    public StoreServiceImplDTO(StoreRepositoryDTO repository) {
        super(repository);
    }
}