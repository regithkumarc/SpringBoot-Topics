package com.example.soapwebservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Articles {

    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long articleId;
    private String title;
    private String category;

    public Articles() {
    }

    public Articles(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article Id : " + articleId + " : Title : " + title + " : Category : " + category;
    }
}
