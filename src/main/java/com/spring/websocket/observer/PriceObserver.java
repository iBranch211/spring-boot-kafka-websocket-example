package com.spring.websocket.observer;

import com.spring.websocket.model.response.PriceResponseDto;

public interface PriceObserver {

    void update(PriceResponseDto price);

}