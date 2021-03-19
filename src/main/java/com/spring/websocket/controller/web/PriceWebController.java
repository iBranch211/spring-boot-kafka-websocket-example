package com.spring.websocket.controller.web;

import com.spring.websocket.model.request.CommentRequestDto;
import com.spring.websocket.model.response.CommentResponseDto;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Hidden // Hide all endpoints
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Controller
public class PriceWebController {

   final SimpMessagingTemplate simpMessagingTemplate;

   @GetMapping("/")
   public String getPrices() {
      return "prices";
   }

   @GetMapping("/api")
   public String index() {
      return "redirect:/swagger-ui.html";
   }

   @MessageMapping("/chat")
   public void addChatComment(@Payload CommentRequestDto comment) {
      CommentResponseDto dto = CommentResponseDto.builder()
              .fromUser(comment.getFromUser())
              .message(comment.getMessage())
              .timestamp(new Date())
              .build();
      if (comment.getToUser().isEmpty()) {
         simpMessagingTemplate.convertAndSend("/topic/comments", dto);
      } else {
         simpMessagingTemplate.convertAndSendToUser(comment.getToUser(), "/topic/comments", dto);
      }
   }

}