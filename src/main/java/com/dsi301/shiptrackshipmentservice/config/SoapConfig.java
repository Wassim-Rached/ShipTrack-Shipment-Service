package com.dsi301.shiptrackshipmentservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapConfig extends WsConfigurerAdapter {

    // Registers the servlet for handling SOAP requests
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/service/*");
    }

    // Defines the WSDL for the shipment service
    @Bean(name = "shipmentDetailsWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema shipmentSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ShipmentDetailsPort");
        wsdl11Definition.setLocationUri("/service/shipment-details");
        wsdl11Definition.setTargetNamespace("http://www.dsi301.com/xml/shipment");
        wsdl11Definition.setSchema(shipmentSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema shipmentSchema() {
        return new SimpleXsdSchema(new ClassPathResource("shipment.xsd"));
    }
}
