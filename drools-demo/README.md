# Drools Config

# POM.xml

<properties>
	<java.version>1.8</java.version>
	<drools-version>7.15.0.Final</drools-version>
</properties>
	
	
<!-- Drools Configuration -->
<dependency>
	<groupId>org.drools</groupId>
	<artifactId>drools-decisiontables</artifactId>
	<version>${drools-version}</version>
</dependency>

<dependency>
	<groupId>org.drools</groupId>
	<artifactId>drools-core</artifactId>
	<version>${drools-version}</version>
</dependency>

<dependency>
	<groupId>org.drools</groupId>
	<artifactId>drools-compiler</artifactId>
	<version>${drools-version}</version>
</dependency>

-----------------------------------------------------------------------------------------------------------------


@RestController
public class OrderController {

    @Autowired
    private KieSession kieSession;

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order) {
        kieSession.insert(order);
        kieSession.fireAllRules();
        return order;
    }
}


package com.example.droolsdemo;
import com.example.droolsdemo.entity.Order;

rule "HDFC"
when
    orderObject : Order(cardType=="HDFC" && price>1000);
then
    orderObject.setDiscount(10);
end;


-----------------------------------------------------------------------------------------------------------------

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private KieSession kieSession;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        kieSession.insert(employee);
        kieSession.fireAllRules();
        return employeeService.addEmployee(employee);
    }
}


package com.example.droolsdemo;
import com.example.droolsdemo.entity.Employee;
import com.example.droolsdemo.entity.Access;

rule "Developer"
when
    employeeObject : Employee(role=="Developer");
then
    Access access = new Access();
    access.setRead("true");
    access.setWrite("false");
    employeeObject.setAccess(access);
end;