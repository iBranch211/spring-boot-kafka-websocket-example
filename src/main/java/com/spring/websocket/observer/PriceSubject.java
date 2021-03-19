package com.spring.websocket.observer;

public interface PriceSubject {

    void register(PriceObserver priceObserver);

    void unregister(PriceObserver priceObserver);

    void notifyObservers();

}
