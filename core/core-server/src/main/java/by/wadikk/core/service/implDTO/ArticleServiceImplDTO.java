package by.wadikk.core.service.implDTO;

import by.wadikk.core.repository.repositoryDTO.ArticleRepositoryDTO;
import by.wadikk.core.service.ArticleService;
import by.wadikk.core.service.common.CommonServiceImplDTO;
import by.wadikk.persistence.dto.ArticleDto;

public class ArticleServiceImplDTO extends CommonServiceImplDTO<ArticleDto, ArticleRepositoryDTO>
        implements ArticleService {

    public ArticleServiceImplDTO(ArticleRepositoryDTO repository) {
        super(repository);
    }
}
