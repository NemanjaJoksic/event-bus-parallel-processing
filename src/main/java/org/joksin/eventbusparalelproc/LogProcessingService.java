package org.joksin.eventbusparalelproc;

import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogProcessingService extends ProcessingService<String> {

    public LogProcessingService(EventBus eventBus) {
        super(eventBus);
    }

    @Override
    protected void processSync(String message) {
        log.info("LogProcessingService: {}", message);
    }

}
