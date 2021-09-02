package by.wadikk.core.service.implJpa;

import by.wadikk.core.mapper.Mapper;
import by.wadikk.core.repository.repositoryJPA.ArticleRepositoryJpa;
import by.wadikk.core.service.ArticleService;
import by.wadikk.core.service.common.CommonServiceImplJPA;
import by.wadikk.persistence.dto.ArticleDto;
import by.wadikk.persistence.entities.Article;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


@ConditionalOnProperty(name = "datasource.type.JPA", havingValue = "true")
@Service
public class ArticleServiceImplJPA extends CommonServiceImplJPA<ArticleDto,Article,ArticleRepositoryJpa>
        implements ArticleService{

    public ArticleServiceImplJPA(ArticleRepositoryJpa repository, Mapper<Article, ArticleDto> mapper) {
        super(repository, mapper);
    }
}