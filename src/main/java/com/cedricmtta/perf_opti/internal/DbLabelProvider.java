package com.cedricmtta.perf_opti.internal;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DbLabelProvider
{

    @Cacheable(cacheNames = "labels")
    public String findLabelFromDbAndTranslateHtml(String labelKey) throws InterruptedException {
        // get the database label to replace label keys by label value in the resulting HTML
        Thread.sleep(100);
        return "Some string imaginary fetched from the DB";
    }
}
