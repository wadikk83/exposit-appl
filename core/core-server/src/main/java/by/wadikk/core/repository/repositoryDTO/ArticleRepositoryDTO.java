package by.wadikk.core.repository.repositoryDTO;

import by.wadikk.core.repository.repositoryDTO.common.AbstractRepositoryDTO;
import by.wadikk.persistence.PersistenceConfiguration;
import by.wadikk.persistence.dto.ArticleDto;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepositoryDTO extends AbstractRepositoryDTO<ArticleDto> {
    public ArticleRepositoryDTO() {
        super(PersistenceConfiguration.ARTICLE_CLASS_NAME);
    }
}
