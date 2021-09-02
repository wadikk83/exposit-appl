package by.wadikk.core.service.implDTO;

import by.wadikk.core.repository.repositoryDTO.ArticleRepositoryDTO;
import by.wadikk.core.service.ArticleService;
import by.wadikk.core.service.common.CommonServiceImplDTO;
import by.wadikk.persistence.dto.ArticleDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "datasource.type.JPA", havingValue = "false")
public class ArticleServiceImplDTO extends CommonServiceImplDTO<ArticleDto, ArticleRepositoryDTO>
        implements ArticleService {

    public ArticleServiceImplDTO(ArticleRepositoryDTO repository) {
        super(repository);
    }
}
