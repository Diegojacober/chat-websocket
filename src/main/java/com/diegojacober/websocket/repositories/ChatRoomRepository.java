package com.diegojacober.websocket.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.diegojacober.websocket.entities.ChatRoom;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String>{
    
    public Optional<ChatRoom> findBySendIdAndRecipientId(String senderId, String recipientId);
}
