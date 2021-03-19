package com.spring.websocket.bootstrap;

import com.spring.websocket.observer.PriceObserver;
import com.spring.websocket.observer.PriceSubjectRunnable;
import com.spring.websocket.service.PriceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Component
public class SimulationRunner implements CommandLineRunner {

    final PriceService priceService;
    final PriceObserver priceObserver;

    @Override
    public void run(String... args) {
        PriceSubjectRunnable priceSubjectRunnable = new PriceSubjectRunnable(priceService);
        priceSubjectRunnable.register(priceObserver);

        new Thread(priceSubjectRunnable).start();
    }

}