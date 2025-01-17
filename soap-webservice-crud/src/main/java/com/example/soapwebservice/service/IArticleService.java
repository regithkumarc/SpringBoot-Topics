package com.example.soapwebservice.service;

import com.example.soapwebservice.entity.Articles;

import java.util.List;

public interface IArticleService {
    List<Articles> getAllArticles();
    Articles getArticleById(long articleId);
    Articles addArticle(Articles articles);
    void updateArticle(Articles articles);
    void deleteArticle(Articles articles);
}
