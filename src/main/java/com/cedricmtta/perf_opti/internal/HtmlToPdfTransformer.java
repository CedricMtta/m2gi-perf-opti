package com.cedricmtta.perf_opti.internal;

import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class HtmlToPdfTransformer {
    @SneakyThrows
    public Resource transform(Resource translatedHtml) {
        someMethodCalledFromAnExternalLibraryThatWeCannotModify();
        return new ByteArrayResource(new byte[]{2,3});
    }

    private void someMethodCalledFromAnExternalLibraryThatWeCannotModify() throws InterruptedException {
        Thread.sleep(300);
    }
}
