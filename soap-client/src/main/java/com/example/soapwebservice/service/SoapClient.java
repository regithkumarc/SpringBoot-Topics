package com.example.soapwebservice.service;

import com.example.soapwebservice.loaneligibility.Acknowledgement;
import com.example.soapwebservice.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    private WebServiceTemplate webServiceTemplate;

    public Acknowledgement getLoanStatus(CustomerRequest request) {
        webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);

        return (Acknowledgement) webServiceTemplate.marshalSendAndReceive("http://localhost:8084/ws",request);
    }
}
