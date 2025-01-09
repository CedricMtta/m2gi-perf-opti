package com.cedricmtta.perf_opti.internal;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
@Slf4j
public class XmlFileProcessingOrchestrator {

    private static final List<String> SUPPORTED_LANGUAGES = List.of("FR", "EN", "DE", "ES", "EL", "IT");

    private final XmlParser xmlParser;
    private final XmlToHtmlTransformer xmlToHtmlTransformer;
    private final HtmlToPdfTransformer htmlToPdfTransformer;
    private final FileStorageService fileStorageService;

    private final ConcurrencyService concurrencyService;

    @SneakyThrows
    public void process(Resource xmlFile) {
        var parsingResult = xmlParser.parse(xmlFile);

        List<CompletableFuture<Void>> list = SUPPORTED_LANGUAGES.stream().map(supportedLanguage -> concurrencyService.executeIfEnoughPermits(() -> {
            Resource translatedHtml = xmlToHtmlTransformer.transform(parsingResult, xmlFile, supportedLanguage);
            Resource translatedPdf = htmlToPdfTransformer.transform(translatedHtml);
            fileStorageService.publishResultingFiles(supportedLanguage, translatedHtml, translatedPdf);
        })).toList();

        log.info("Waiting for all async executions to finish...");
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        log.info("Done");

    }
}
