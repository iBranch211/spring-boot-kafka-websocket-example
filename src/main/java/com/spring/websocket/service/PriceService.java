package com.spring.websocket.service;


import com.spring.websocket.model.request.PriceRequestDto;
import com.spring.websocket.model.response.PriceResponseDto;

public interface PriceService {

    PriceResponseDto getLastPrice();

    PriceResponseDto savePrice(PriceRequestDto priceRequestDto);
}
