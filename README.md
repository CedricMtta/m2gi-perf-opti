# M2 GI - Performance optimization

## Goal

This small project aims to emulate a real life scenario where you are tasked to optimize an application.

## Imaginary context

This java code is part of a microservice.
This microservice is responsible for receiving some XML data, transforming it into HTML then PDF.

The resulting HTML and PDF must be available in multiple language.
The labels, in each language, of some keys present in the XML, are stored in DB.

This project won't implement the real code, but just some comments and Thread.sleep to mimick performance issue.

## Technical process steps involve

- Receive some XML content, no matter the way (imagine a REST endpoint, a Rabbit MQ Listener, a Kafka Topic Listener ...);
- Parse this XML using DOM;
- Transform the XML into HTML thanks to some custom code made by the dev team. At the same time, query the DB to obtain the labels;
- Transform the HTML into PDF, thanks to an external API;
- Once available, store it in the cloud, imagine an S3.

## Battle plan

- Before performing any optimization, setup a test measuring the time it takes to execute the process. Developer must be comfortable to execute the scenario to optimize, and benchmark it before;
- Perform CPU sample to identify main performance bottleneck plans;
- Investigate if the code can be refactored to be more performant;
  - StAX instead of DOM;
  - Singleton to load the parsers.
- Leverage caching mechanism (Caffeine for java);
- Multi threading when possible.