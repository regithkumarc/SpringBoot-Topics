package com.example.soapwebservice.controller;

import com.example.soapwebservice.articles.*;
import com.example.soapwebservice.service.SoapArticlesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticlesController {

    @Autowired
    private SoapArticlesClient soapArticlesClient;

    @GetMapping("/getNameArticlesController")
    public String getNameArticlesController() {
        return "Getting the ArticlesController";
    }

    @GetMapping("/getArticlesById/{articleId}")
    public GetArticlesByIdResponse getArticlesById(@PathVariable Long articleId) {
        return soapArticlesClient.getArticlesById(articleId);
    }

    @GetMapping("/getAllArticles")
    public GetAllArticlesResponse getAllArticles() {
        return soapArticlesClient.getAllArticles();
    }

    @PostMapping("/addArticles")
    public AddArticlesResponse addArticles(@RequestBody AddArticlesRequest request) {
        return soapArticlesClient.addArticles(request);
    }

    @PutMapping("/updateArticles")
    public UpdateArticlesResponse updateArticles(@RequestBody UpdateArticlesRequest request) {
        return soapArticlesClient.updateArticles(request);
    }

    @DeleteMapping("/deleteArticlesById/{articleId}")
    public DeleteArticlesResponse deleteArticlesById(@PathVariable Long articleId) {
        return soapArticlesClient.deleteArticlesById(articleId);
    }
}
