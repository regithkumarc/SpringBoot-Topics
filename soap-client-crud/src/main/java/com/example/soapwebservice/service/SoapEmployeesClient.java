package com.example.soapwebservice.service;

import com.example.soapwebservice.articles.*;
import com.example.soapwebservice.employees.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapEmployeesClient {

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    private WebServiceTemplate webServiceTemplate;

    public static final String URL = "http://localhost:8086/ws";

    public GetEmployeesByIdResponse getEmployeesById(Long employeeId) {
        GetEmployeesByIdRequest request = new GetEmployeesByIdRequest();
        request.setEmployeeId(employeeId);
        return (GetEmployeesByIdResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    public GetAllEmployeesResponse getAllEmployees() {
        GetAllEmployeesRequest request = new GetAllEmployeesRequest();
        return (GetAllEmployeesResponse) getWebServiceTemplate().marshalSendAndReceive(URL,request);
    }

    public AddEmployeesResponse addEmployees(AddEmployeesRequest request) {
        return (AddEmployeesResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    public UpdateEmployeesResponse updateEmployees(UpdateEmployeesRequest request) {
        return (UpdateEmployeesResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    public DeleteEmployeesResponse deleteEmployeesById(Long employeeId) {
        DeleteEmployeesRequest request = new DeleteEmployeesRequest();
        request.setEmployeeId(employeeId);
        return (DeleteEmployeesResponse) getWebServiceTemplate().marshalSendAndReceive(URL, request);
    }

    private WebServiceTemplate getWebServiceTemplate() {
        webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        return webServiceTemplate;
    }
}
