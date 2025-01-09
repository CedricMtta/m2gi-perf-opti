package com.cedricmtta.perf_opti.internal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.stream.XMLInputFactory;

@Configuration
public class StaxXmlInputFactoryConfiguration {
    @Bean
    public XMLInputFactory getXmlInputFactory() {
        return XMLInputFactory.newFactory();
    }
}
