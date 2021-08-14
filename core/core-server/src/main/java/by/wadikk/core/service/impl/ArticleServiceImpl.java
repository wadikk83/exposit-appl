package by.wadikk.core.service.impl;

import by.wadikk.core.model.Article;
import by.wadikk.core.repository.ArticleRepository;
import by.wadikk.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public boolean create(Article article) {
        if (articleRepository.findById(article.getId()) == null) {
            articleRepository.save(article);
            return true;
        }
        return false;
    }

    @Override
    public List<Article> readAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article read(long id) {
        return articleRepository.getById(id);
    }

    @Override
    public boolean update(Article article, long id) {
        if (articleRepository.getById(id) != null) {
            articleRepository.save(article);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (articleRepository.findById(id) != null) {
            articleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
