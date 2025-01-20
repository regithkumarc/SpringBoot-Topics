package com.example.soapwebservice.endpoint;

import com.example.soapwebservice.articles.*;
import com.example.soapwebservice.entity.Articles;
import com.example.soapwebservice.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class ArticleEndpoint {

    private static final String NAMESPACE = "http://www.example.com/soapwebservice/articles";

    @Autowired
    private ArticleService articleService;

    @PayloadRoot(namespace = NAMESPACE, localPart = "getArticlesByIdRequest")
    @ResponsePayload
    public GetArticlesByIdResponse getArticlesByIdRequest(@RequestPayload GetArticlesByIdRequest getArticlesByIdRequest) {
        GetArticlesByIdResponse response = new GetArticlesByIdResponse();
        ArticlesInfo articleInfo = new ArticlesInfo();
        Articles articles = articleService.getArticleById(getArticlesByIdRequest.getArticleId());
        System.out.println("Articles : " + articles);
        if (articles != null) {
            BeanUtils.copyProperties(articles, articleInfo);
            response.setArtricleInfo(articleInfo);
        }

        System.out.println("Get Articles By ID Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getAllArticlesRequest")
    @ResponsePayload
    public GetAllArticlesResponse getAllArticlesRequest(@RequestPayload GetAllArticlesRequest getAllArticlesRequest) {
        GetAllArticlesResponse response = new GetAllArticlesResponse();
        List<ArticlesInfo> articleInfoList = new ArrayList<>();

        List<Articles> articlesList = articleService.getAllArticles();
        ArticlesInfo articleInfo = null;
        for(int i=0; i<articlesList.size(); i++) {
            articleInfo = new ArticlesInfo();
            BeanUtils.copyProperties(articlesList.get(i), articleInfo);
            articleInfoList.add(articleInfo);
        }

        response.getArticleInfo().addAll(articleInfoList);
        System.out.println("Get All Articles Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "addArticlesRequest")
    @ResponsePayload
    public AddArticlesResponse addArticlesRequest(@RequestPayload AddArticlesRequest addArticleRequest) {
        AddArticlesResponse response = new AddArticlesResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        Articles articles = new Articles();
        articles.setTitle(addArticleRequest.getTitle());
        articles.setCategory(addArticleRequest.getCategory());

        Articles addedArticle = articleService.addArticle(articles);
        System.out.println("addedArticle : " + addedArticle);
        if (addedArticle != null) {
            ArticlesInfo articleInfo = new ArticlesInfo();
            BeanUtils.copyProperties(articles, articleInfo);
            response.setArticleInfo(articleInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Data Added Successfully");
        } else {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Data Already Available");
        }

        response.setServiceStatus(serviceStatus);
        System.out.println("Added Articles Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "updateArticlesRequest")
    @ResponsePayload
    public UpdateArticlesResponse updateArticlesRequest(@RequestPayload UpdateArticlesRequest request) {
        UpdateArticlesResponse response = new UpdateArticlesResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Articles articles = articleService.getArticleById(request.getArticleId());
        if (articles != null) {
            Articles updateArticles = new Articles();
            updateArticles.setArticleId(request.getArticleId());
            updateArticles.setTitle(request.getTitle());
            updateArticles.setCategory(request.getCategory());
            articleService.updateArticle(updateArticles);

            ArticlesInfo articleInfo = new ArticlesInfo();
            BeanUtils.copyProperties(updateArticles, articleInfo);
            response.setArticleInfo(articleInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Data Updated Successfully");
        } else {
            serviceStatus.setStatusCode("NO DATA");
            serviceStatus.setMessage("No Data Available");
        }

        response.setServiceStatus(serviceStatus);
        System.out.println("Updated Articles Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "deleteArticlesRequest")
    @ResponsePayload
    public DeleteArticlesResponse deleteArticlesRequest(@RequestPayload DeleteArticlesRequest request) {
        DeleteArticlesResponse response = new DeleteArticlesResponse();
        Articles articles = articleService.getArticleById(request.getArticleId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (articles != null) {
            ArticlesInfo articleInfo = new ArticlesInfo();
            BeanUtils.copyProperties(articles, articleInfo);
            response.setArticleInfo(articleInfo);
            articleService.deleteArticle(articles);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Data Deleted Successfully");
        } else {
            serviceStatus.setStatusCode("NO DATA");
            serviceStatus.setMessage("No Data Available");
        }

        response.setServiceStatus(serviceStatus);
        System.out.println("Deleted Articles Response : " + response);
        return response;
    }

}
