package com.example.soapwebservice.service;


import com.example.soapwebservice.entity.Articles;
import com.example.soapwebservice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Articles> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Articles getArticleById(long articleId) {
        Optional<Articles> optional = articleRepository.findById(articleId);
        return optional.orElse(null);
    }

    @Override
    public Articles addArticle(Articles articles) {
        articleRepository.save(articles);
        Optional<Articles> optional = articleRepository.findById(articles.getArticleId());
        return optional.orElse(null);
    }

    @Override
    public void updateArticle(Articles articles) {
        Optional<Articles> optional = articleRepository.findById(articles.getArticleId());
        if (optional.isPresent()) {
            articleRepository.save(articles);
        }
    }

    @Override
    public void deleteArticle(Articles articles) {
        Optional<Articles> optional = articleRepository.findById(articles.getArticleId());
        if (optional.isPresent()) {
            articleRepository.deleteById(articles.getArticleId());
        }
    }
}
