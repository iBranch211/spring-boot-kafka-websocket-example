package com.spring.websocket.repository;


import com.spring.websocket.domain.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {

    Price findTopByOrderByCreatedDateDesc();

}