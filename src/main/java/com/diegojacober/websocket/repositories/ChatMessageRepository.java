package com.diegojacober.websocket.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diegojacober.websocket.entities.ChatMessage;

@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String>{
   List<ChatMessage> findByChatId(String chatId);
}
