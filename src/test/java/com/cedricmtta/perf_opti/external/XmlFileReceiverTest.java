package com.cedricmtta.perf_opti.external;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StopWatch;

@SpringBootTest
@Slf4j
class XmlFileReceiverTest {

    @Autowired
    private XmlFileReceiver xmlFileReceiver;

    @Test
    void performanceTest() {
        var xmlFileToTransform = new ClassPathResource("XmlFileReceiverTest/SampleData.xml");

        var stopwatch = new StopWatch();
        stopwatch.start();

        for (int i = 0; i < 5; i++) {

            log.info("=======================");
            log.info("Round " + i);
            log.info("=======================");
            xmlFileReceiver.receiveXmlFile(xmlFileToTransform);
        }

        stopwatch.stop();

        System.out.println("The process took : " + stopwatch.prettyPrint());
    }
}