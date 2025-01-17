package com.example.soapwebservice.service;

import com.example.soapwebservice.articles.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    private WebServiceTemplate webServiceTemplate;

    public static final String URL = "http://localhost:8086/ws";

    public GetArticlesByIdResponse getArticlesById(Long articleId) {
        GetArticlesByIdRequest request = new GetArticlesByIdRequest();
        request.setArticleId(articleId);
        return (GetArticlesByIdResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    public GetAllArticlesResponse getAllArticles() {
        GetAllArticlesRequest request = new GetAllArticlesRequest();
        return (GetAllArticlesResponse) getWebServiceTemplate().marshalSendAndReceive(URL,request);
    }

    public AddArticlesResponse addArticles(AddArticlesRequest request) {
        return (AddArticlesResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    public UpdateArticlesResponse updateArticles(UpdateArticlesRequest request) {
        return (UpdateArticlesResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    public DeleteArticlesResponse deleteArticles(Long articleId) {
        DeleteArticlesRequest request = new DeleteArticlesRequest();
        request.setArticleId(articleId);
        return (DeleteArticlesResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    private WebServiceTemplate getWebServiceTemplate() {
        webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        return webServiceTemplate;
    }
}
