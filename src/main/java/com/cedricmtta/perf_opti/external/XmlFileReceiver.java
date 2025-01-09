package com.cedricmtta.perf_opti.external;

import com.cedricmtta.perf_opti.internal.XmlFileProcessingOrchestrator;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class XmlFileReceiver {
    private final XmlFileProcessingOrchestrator xmlFileProcessingOrchestrator;

    // Imagine this method is triggered by an external service, be it from a REST API, a Rabbit MQ Queue listener, a Kafka topic listener, or whatever.
    public void receiveXmlFile(Resource xmlFile) {
        xmlFileProcessingOrchestrator.process(xmlFile);
    }

}
