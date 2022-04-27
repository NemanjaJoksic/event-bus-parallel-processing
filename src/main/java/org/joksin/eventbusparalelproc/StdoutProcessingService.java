package org.joksin.eventbusparalelproc;

import com.google.common.eventbus.EventBus;
import org.springframework.stereotype.Service;

@Service
public class StdoutProcessingService extends ProcessingService<String> {

    public StdoutProcessingService(EventBus eventBus) {
        super(eventBus);
    }

    @Override
    protected void processSync(String message) {
        System.out.println("[" + Thread.currentThread().getName() + "] StdoutProcessingService: " + message);
    }

}
