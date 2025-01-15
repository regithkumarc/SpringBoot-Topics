package com.example.soapwebservice.endpoint;

import com.example.soapwebservice.loaneligibility.Acknowledgement;
import com.example.soapwebservice.loaneligibility.CustomerRequest;
import com.example.soapwebservice.service.LoanEligibiltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityEndpoint {

    private static final String NAMESPACE = "http://www.example.com/soapwebservice/loanEligibility";

    @Autowired
    private LoanEligibiltyService loanEligibiltyService;

    @PayloadRoot(namespace = NAMESPACE,localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest customerRequest) {
        return loanEligibiltyService.checkLoanEligibilty(customerRequest);
    }
}
