package com.cedricmtta.perf_opti.external;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StopWatch;

import java.io.FileNotFoundException;

@SpringBootTest
class XmlFileReceiverTest {

    @Autowired
    private XmlFileReceiver xmlFileReceiver;

    @Test
    void performanceTest() throws FileNotFoundException {
        var xmlFileToTransform = new ClassPathResource("XmlFileReceiverTest/SampleData.xml");

        var stopwatch = new StopWatch();
        stopwatch.start();

        for (int i = 0; i < 5; i++) {
            xmlFileReceiver.receiveXmlFile(xmlFileToTransform);
        }

        stopwatch.stop();

        System.out.println("The process took : " + stopwatch.prettyPrint());
    }
}