package com.example.soapwebservice.controller;


import com.example.soapwebservice.articles.*;
import com.example.soapwebservice.service.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticlesController {

    @Autowired
    private SoapClient soapClient;

    @GetMapping("/getNames")
    public String getName() {
        return "Getting the ArticlesController";
    }

    @GetMapping("/getArticlesById/{articleId}")
    public GetArticlesByIdResponse getArticlesById(@PathVariable Long articleId) {
        return soapClient.getArticlesById(articleId);
    }

    @GetMapping("/getAllArticles")
    public GetAllArticlesResponse getAllArticles() {
        return soapClient.getAllArticles();
    }

    @PostMapping("/addArticles")
    public AddArticlesResponse addArticles(@RequestBody AddArticlesRequest request) {
        return soapClient.addArticles(request);
    }

    @PutMapping("/updateArticles")
    public UpdateArticlesResponse updateArticles(@RequestBody UpdateArticlesRequest request) {
        return soapClient.updateArticles(request);
    }

    @DeleteMapping("/deleteArticles/{articleId}")
    public DeleteArticlesResponse deleteArticles(@PathVariable Long articleId) {
        return soapClient.deleteArticles(articleId);
    }
}
