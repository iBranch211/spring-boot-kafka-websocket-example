package com.spring.websocket.mapper;

import com.spring.websocket.domain.Price;
import com.spring.websocket.mapper.base.BaseMapper;
import com.spring.websocket.model.request.PriceRequestDto;
import com.spring.websocket.model.response.PriceResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PriceMapper extends BaseMapper<PriceResponseDto, PriceRequestDto, Price> {

    @Mapping(source = "createdDate",target = "timestamp")
    PriceResponseDto tToR(Price price);
}
