package com.example.soapwebservice.endpoint;

import com.example.soapwebservice.employees.*;
import com.example.soapwebservice.entity.Employees;
import com.example.soapwebservice.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class EmployeesEndpoint {

    private static final String NAMESPACE = "http://www.example.com/soapwebservice/employees";

    @Autowired
    private EmployeeService employeeService;

    @PayloadRoot(namespace = NAMESPACE, localPart = "getEmployeesByIdRequest")
    @ResponsePayload
    public GetEmployeesByIdResponse getEmployeesByIdRequest(@RequestPayload GetEmployeesByIdRequest getEmployeesByIdRequest) {
        GetEmployeesByIdResponse response = new GetEmployeesByIdResponse();
        EmployeesInfo employeesInfo = new EmployeesInfo();
        Employees articles = employeeService.getEmployeeById(getEmployeesByIdRequest.getEmployeeId());
        System.out.println("Employees : " + articles);
        if (articles != null) {
            BeanUtils.copyProperties(articles, employeesInfo);
            response.setEmployeeInfo(employeesInfo);
        }

        System.out.println("Get Employees By ID Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getAllEmployeesRequest")
    @ResponsePayload
    public GetAllEmployeesResponse getAllEmployeesRequest(@RequestPayload GetAllEmployeesRequest getAllEmployeesRequest) {
        GetAllEmployeesResponse response = new GetAllEmployeesResponse();
        List<EmployeesInfo> employeesInfoList = new ArrayList<>();

        List<Employees> employeesList = employeeService.getAllEmployees();
        EmployeesInfo employeesInfo = null;
        for(int i=0; i<employeesList.size(); i++) {
            employeesInfo = new EmployeesInfo();
            BeanUtils.copyProperties(employeesList.get(i), employeesInfo);
            employeesInfoList.add(employeesInfo);
        }

        response.getEmployeeInfo().addAll(employeesInfoList);
        System.out.println("Get All Employees Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "addEmployeesRequest")
    @ResponsePayload
    public AddEmployeesResponse addEmployeesRequest(@RequestPayload AddEmployeesRequest addEmployeesRequest) {
        AddEmployeesResponse response = new AddEmployeesResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        Employees employees = new Employees();
        employees.setName(addEmployeesRequest.getName());
        employees.setRole(addEmployeesRequest.getRole());

        Employees addedEmployee = employeeService.addEmployee(employees);
        System.out.println("addedEmployees : " + addedEmployee);
        if (addedEmployee != null) {
            EmployeesInfo employeesInfo = new EmployeesInfo();
            BeanUtils.copyProperties(employees, employeesInfo);
            response.setEmployeeInfo(employeesInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Data Added Successfully");
        } else {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Data Already Available");
        }

        response.setServiceStatus(serviceStatus);
        System.out.println("Added Employees Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "updateEmployeesRequest")
    @ResponsePayload
    public UpdateEmployeesResponse updateEmployeesRequest(@RequestPayload UpdateEmployeesRequest updateEmployeesRequest) {
        UpdateEmployeesResponse response = new UpdateEmployeesResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Employees employee = employeeService.getEmployeeById(updateEmployeesRequest.getEmployeeId());
        if (employee != null) {
            Employees updateEmployee = new Employees();
            updateEmployee.setEmployeeId(updateEmployeesRequest.getEmployeeId());
            updateEmployee.setName(updateEmployeesRequest.getName());
            updateEmployee.setRole(updateEmployeesRequest.getRole());
            employeeService.updateEmployee(updateEmployee);

            EmployeesInfo employeesInfo = new EmployeesInfo();
            BeanUtils.copyProperties(updateEmployee, employeesInfo);
            response.setEmployeeInfo(employeesInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Data Updated Successfully");
        } else {
            serviceStatus.setStatusCode("NO DATA");
            serviceStatus.setMessage("No Data Available");
        }

        response.setServiceStatus(serviceStatus);
        System.out.println("Updated Employees Response : " + response);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "deleteEmployeesRequest")
    @ResponsePayload
    public DeleteEmployeesResponse deleteEmployeesRequest(@RequestPayload DeleteEmployeesRequest deleteEmployeesRequest) {
        DeleteEmployeesResponse response = new DeleteEmployeesResponse();
        Employees employees = employeeService.getEmployeeById(deleteEmployeesRequest.getEmployeeId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (employees != null) {
            EmployeesInfo employeesInfo = new EmployeesInfo();
            BeanUtils.copyProperties(employees, employeesInfo);
            response.setEmployeeInfo(employeesInfo);
            employeeService.deleteEmployeeById(employees);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Data Deleted Successfully");
        } else {
            serviceStatus.setStatusCode("NO DATA");
            serviceStatus.setMessage("No Data Available");
        }

        response.setServiceStatus(serviceStatus);
        System.out.println("Deleted Employees Response : " + response);
        return response;
    }

}
