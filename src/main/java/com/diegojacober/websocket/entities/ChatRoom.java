package com.diegojacober.websocket.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document
public class ChatRoom {
    @Id
    private String id;
    private String chatId;
    private String sendId;
    private String recipientId;
}
