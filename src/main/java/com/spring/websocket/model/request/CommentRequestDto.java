package com.spring.websocket.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentRequestDto {

    String fromUser;
    String toUser;
    String message;

}