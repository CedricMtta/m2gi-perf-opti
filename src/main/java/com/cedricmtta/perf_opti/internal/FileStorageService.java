package com.cedricmtta.perf_opti.internal;

import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class FileStorageService {
    @SneakyThrows
    public void publishResultingFiles(String supportedLanguage, Resource translatedHtml, Resource translatedPdf) {
        // Storing this to S3 or alike
        Thread.sleep(20);
    }
}
