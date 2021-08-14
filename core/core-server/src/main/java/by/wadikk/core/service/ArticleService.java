package by.wadikk.core.service;

import by.wadikk.core.model.Article;
import by.wadikk.core.model.AttributeName;

import java.util.List;

public interface ArticleService {

    boolean create(Article article);

    List<Article> readAll();

    Article read(long id);

    boolean update(Article article, long id);

    boolean delete(long id);
}
