package com.spring.websocket.service.impl;

import com.spring.websocket.domain.Price;
import com.spring.websocket.mapper.PriceMapper;
import com.spring.websocket.model.request.PriceRequestDto;
import com.spring.websocket.model.response.PriceResponseDto;
import com.spring.websocket.repository.PriceRepository;
import com.spring.websocket.service.PriceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class PriceServiceImpl  implements PriceService {

    final PriceRepository priceRepository;
    final PriceMapper priceMapper;

    @Override
    public PriceResponseDto getLastPrice() {
        Price price = priceRepository.findTopByOrderByCreatedDateDesc();
        return priceMapper.tToR(price);
    }

    @Override
    public PriceResponseDto savePrice(PriceRequestDto priceRequestDto) {
        Price price = priceMapper.wToT(priceRequestDto);
        price =  priceRepository.save(price);
        return priceMapper.tToR(price);
    }
}

