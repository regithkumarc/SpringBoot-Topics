package com.example.soapwebservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SoapConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServletServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<MessageDispatcherServlet>(messageDispatcherServlet, "/ws/*");
    }

/*    @Bean("articles")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchemaCollection xsdSchemaCollection) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("ArticleEndpoint");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace("http://www.example.com/soapwebservice/");
        //defaultWsdl11Definition.setSchema(xsdSchema);
        defaultWsdl11Definition.setSchemaCollection(xsdSchemaCollection);
        return defaultWsdl11Definition;
    }*/

    @Bean("articles")
    public DefaultWsdl11Definition articles(XsdSchema xsdSchema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("ArticleEndpoint");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace("http://www.example.com/soapwebservice/articles");
        defaultWsdl11Definition.setSchema(articlesSchema());

        return defaultWsdl11Definition;
    }

    @Bean("employees")
    public DefaultWsdl11Definition employees(XsdSchema xsdSchema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("EmployeesEndPoint");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace("http://www.example.com/soapwebservice/employees");
        defaultWsdl11Definition.setSchema(employeeSchema());

        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema articlesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("articles.xsd"));
    }

    @Bean
    @Primary
    public XsdSchema employeeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("employees.xsd"));
    }


/*    @Bean
    public XsdSchemaCollection xsdSchemaCollection() {

        return new XsdSchemaCollection() {

            @Override
            public XmlValidator createValidator() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public XsdSchema[] getXsdSchemas() {
                return new XsdSchema[]{articlesSchema(), employeeSchema()};
            }
        };
    }*/

}
