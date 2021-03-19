package com.spring.websocket.observer;

import com.spring.websocket.model.response.PriceResponseDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Log4j2
@Component
public class StreamPriceObserver implements PriceObserver {

    final StreamBridge streamBridge;

    @Override
    public void update(PriceResponseDto price) {
        Message<PriceResponseDto> message = MessageBuilder.withPayload(price)
                .setHeader("partitionKey", price.getId())
                .build();
        streamBridge.send("prices-out-0", message);

        log.info("{} sent to bus.", message);
    }
}