package com.spring.websocket.observer;

import com.spring.websocket.model.request.PriceRequestDto;
import com.spring.websocket.model.response.PriceResponseDto;
import com.spring.websocket.service.PriceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Log4j2
@RequiredArgsConstructor
public class PriceSubjectRunnable implements PriceSubject, Runnable {

    static final int SLEEP_TIME = 1000;
    static final int TRADE_DIFFICULT = 4;
    static final Random rand = new SecureRandom();
    static final BigDecimal INITIAL_PRICE = new BigDecimal(6000);

    List<PriceObserver> observers = new ArrayList<>();

    PriceResponseDto price;

    final PriceService priceService;

    @Override
    public void run() {
       price=priceService.savePrice(getPriceRequestDto());

        while (true) {
            try {
                Thread.sleep(SLEEP_TIME);

                boolean hasTrade = simulateTrade();
                if (hasTrade) {
                    PriceRequestDto dto = getNewPrice(INITIAL_PRICE);
                    price = priceService.savePrice(dto);
                    notifyObservers();
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
    }

    @Override
    public void register(PriceObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(PriceObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        log.info("New {}", price);
        observers.forEach(observer -> observer.update(price));
    }

    private boolean simulateTrade() {
        boolean trade = true;
        int i = 0;
        do {
            trade = trade && rand.nextBoolean();
            ++i;
        } while (i < TRADE_DIFFICULT);
        return trade;
    }

    private PriceRequestDto getNewPrice(BigDecimal currentPrice) {
        boolean sign = rand.nextBoolean();
        double var = rand.nextDouble() * 100;
        BigDecimal variation = BigDecimal.valueOf(sign ? var : -1 * var);
        BigDecimal newValue = currentPrice.add(variation).setScale(2, RoundingMode.HALF_UP);
        return PriceRequestDto.builder()
                .value(newValue)
                .build();
    }

    private PriceRequestDto getPriceRequestDto(){
         return PriceRequestDto.builder()
                .value(INITIAL_PRICE)
                .build();
    }

}