package com.cedricmtta.perf_opti.internal;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import java.nio.charset.StandardCharsets;

@Service
@AllArgsConstructor
public class XmlParser {

    private final XMLInputFactory xmlInputFactory;

    public record FileProcessingMetadata(String templateName, String someParameter, String otherParameter){}

    @SneakyThrows
    public FileProcessingMetadata parse(Resource xmlFile) {
        @Cleanup var xmlFileInputStream = xmlFile.getInputStream();

        // Code to parse the file with DOM goes here
        xmlInputFactory.createXMLEventReader(xmlFileInputStream);
        Thread.sleep(25);

        return new FileProcessingMetadata("Some template name", "value 1", "value 2");
    }
}
