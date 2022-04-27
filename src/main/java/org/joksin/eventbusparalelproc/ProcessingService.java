package org.joksin.eventbusparalelproc;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class ProcessingService<T> {

    private ExecutorService executorService;

    public ProcessingService(EventBus eventBus) {
        eventBus.register(this);
        this.executorService = Executors.newFixedThreadPool(4);
    }

    @Subscribe
    public void processAsync(T t) {
        CompletableFuture.runAsync(() -> processSync(t), executorService);
    }

    protected abstract void processSync(T t);

}
