package org.joksin.eventbusparalelproc;

import com.google.common.eventbus.EventBus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final EventBus eventBus;

    public Runner(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void run(String... args) throws Exception {
        String messageTemplate = "Test message number #NUM#";
        for (int i = 1; i <= 10; i++) {
            eventBus.post(messageTemplate.replace("#NUM#", String.valueOf(i)));
        }

        Thread.sleep(1500);
        System.exit(0);
    }

}
