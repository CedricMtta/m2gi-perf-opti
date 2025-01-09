package com.cedricmtta.perf_opti.internal;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.xml.parsers.DocumentBuilderFactory;

@Service
public class XmlParser {

    public record FileProcessingMetadata(String templateName, String someParameter, String otherParameter){}

    @SneakyThrows
    public FileProcessingMetadata parse(Resource xmlFile) {
        @Cleanup var xmlFileInputStream = xmlFile.getInputStream();

        var builder = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
        // Code to parse the file with DOM goes here
        Thread.sleep(50);

        return new FileProcessingMetadata("Some template name", "value 1", "value 2");
    }
}
