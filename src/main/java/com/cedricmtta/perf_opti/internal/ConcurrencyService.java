package com.cedricmtta.perf_opti.internal;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

@Service
@Slf4j
public class ConcurrencyService {

    private final Semaphore memorySemaphore = new Semaphore(4);

    @SneakyThrows
    @Async
    public CompletableFuture<Void> executeIfEnoughPermits(Runnable runnable) {
        log.info("Trying to acquire 1 permit...");
        memorySemaphore.acquire(1);
        log.info("Successfully acquired permit !");

        log.info("Executing task on dedicated thread...");
        runnable.run();
        log.info("Successfully executed task !");

        log.info("Releasing 1 permit...");
        memorySemaphore.release(1);
        log.info("Successfully released permit !");
        return CompletableFuture.completedFuture(null);
    }

}
