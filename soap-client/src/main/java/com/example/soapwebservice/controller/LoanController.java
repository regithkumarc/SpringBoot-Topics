package com.example.soapwebservice.controller;

import com.example.soapwebservice.loaneligibility.Acknowledgement;
import com.example.soapwebservice.loaneligibility.CustomerRequest;
import com.example.soapwebservice.service.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private SoapClient soapClient;

    @PostMapping("/getLoanStatus")
    public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
        return soapClient.getLoanStatus(request);
    }
}
