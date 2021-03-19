package com.spring.websocket.listener;

import com.spring.websocket.model.response.PriceResponseDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Log4j2
@RequiredArgsConstructor
@Component
public class PriceStream {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Bean
    public Consumer<Message<PriceResponseDto>> prices() {
        return message -> {
            PriceResponseDto price = message.getPayload();
            MessageHeaders messageHeaders = message.getHeaders();
            log.info("PriceMessage with id {}, value '{}' and timestamp '{}' received from bus. topic: {}, partition: {}, offset: {}, deliveryAttempt: {}",
                    price.getId(), price.getValue(), price.getTimestamp(),
                    messageHeaders.get(KafkaHeaders.RECEIVED_TOPIC, String.class),
                    messageHeaders.get(KafkaHeaders.RECEIVED_PARTITION_ID, Integer.class),
                    messageHeaders.get(KafkaHeaders.OFFSET, Long.class),
                    messageHeaders.get(IntegrationMessageHeaderAccessor.DELIVERY_ATTEMPT, AtomicInteger.class));

            simpMessagingTemplate.convertAndSend("/topic/prices", price);
        };
    }

}