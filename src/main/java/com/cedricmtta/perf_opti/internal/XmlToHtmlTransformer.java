package com.cedricmtta.perf_opti.internal;

import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class XmlToHtmlTransformer {


    @SneakyThrows
    public Resource transform(XmlParser.FileProcessingMetadata parsingResult, Resource xmlFile, String supportedLanguage) {
        transformXmlIntoHtml();

        findLabelFromDbAndTranslateHtml();

        return new ByteArrayResource(new byte[]{0,1});
    }

    private static void transformXmlIntoHtml() throws InterruptedException {
        // Apply some XSLT or whatever technology to transform the xml file in HTML
        Thread.sleep(150);
    }

    private static void findLabelFromDbAndTranslateHtml() throws InterruptedException {
        // get the database label to replace label keys by label value in the resulting HTML
        Thread.sleep(100);
    }
}
