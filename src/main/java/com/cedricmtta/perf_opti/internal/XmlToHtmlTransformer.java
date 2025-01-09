package com.cedricmtta.perf_opti.internal;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class XmlToHtmlTransformer {

    private final DbLabelProvider dbLabelProvider;

    @SneakyThrows
    public Resource transform(XmlParser.FileProcessingMetadata parsingResult, Resource xmlFile, String supportedLanguage) {
        transformXmlIntoHtml();

        dbLabelProvider.findLabelFromDbAndTranslateHtml(parsingResult.someParameter());

        return new ByteArrayResource(new byte[]{0,1});
    }

    private static void transformXmlIntoHtml() throws InterruptedException {
        // Apply some XSLT or whatever technology to transform the xml file in HTML
        Thread.sleep(150);
    }
}
