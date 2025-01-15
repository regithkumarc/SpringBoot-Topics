package com.example.soapwebservice.service;

import com.example.soapwebservice.loaneligibility.Acknowledgement;
import com.example.soapwebservice.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanEligibiltyService {

    public Acknowledgement checkLoanEligibilty(CustomerRequest request) {
        Acknowledgement acknowledgement = new Acknowledgement();

        List<String> misMatchCriteriaList = acknowledgement.getCriteriaMismatch();

        System.out.println("misMatchCriteriaList : " + misMatchCriteriaList);
        if(!(request.getAge() > 30 && request.getAge() <= 60)) {
            misMatchCriteriaList.add("Person age should be in between 30 to 60");
        }

        if(!(request.getYearlyIncome() > 200000)) {
            misMatchCriteriaList.add("Minimum income should be more than 200000");
        }

        if(!(request.getCibilScore() > 500)) {
            misMatchCriteriaList.add("Low cibil score please try after 6 month");
        }

        if(misMatchCriteriaList.size() > 0) {
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        } else {
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.setIsEligible(true);
            misMatchCriteriaList.clear();
        }

        return acknowledgement;
    }
}
