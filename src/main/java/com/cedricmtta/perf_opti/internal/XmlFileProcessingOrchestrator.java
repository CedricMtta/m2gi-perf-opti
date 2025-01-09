package com.cedricmtta.perf_opti.internal;

import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class XmlFileProcessingOrchestrator {

    private static final List<String> SUPPORTED_LANGUAGES = List.of("FR", "EN", "DE", "ES", "EL", "IT");

    private final XmlParser xmlParser;
    private final XmlToHtmlTransformer xmlToHtmlTransformer;
    private final HtmlToPdfTransformer htmlToPdfTransformer;
    private final FileStorageService fileStorageService;

    public void process(Resource xmlFile) {
        var parsingResult = xmlParser.parse(xmlFile);

        SUPPORTED_LANGUAGES.forEach(supportedLanguage -> {
            Resource translatedHtml = xmlToHtmlTransformer.transform(parsingResult, xmlFile, supportedLanguage);
            Resource translatedPdf = htmlToPdfTransformer.transform(translatedHtml);
            fileStorageService.publishResultingFiles(supportedLanguage, translatedHtml, translatedPdf);
        });
    }
}
