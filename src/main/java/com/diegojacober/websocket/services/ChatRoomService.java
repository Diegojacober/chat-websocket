package com.diegojacober.websocket.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegojacober.websocket.entities.ChatRoom;
import com.diegojacober.websocket.repositories.ChatRoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository repository;

    public Optional<String> getChatRoomId(String senderId, String recipientId, boolean createNewRoomIfNotExists) {
        return repository.findBySendIdAndRecipientId(senderId, recipientId)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if (createNewRoomIfNotExists) {
                        var chatId = createChatId(senderId, recipientId);
                        return Optional.of(chatId);
                    }
                    return Optional.empty();
                });
    }

    private String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s", senderId, recipientId); // diego_angelo

        // 2 chatrooms um para cada
        ChatRoom senderRecipient = ChatRoom
                .builder()
                .sendId(senderId)
                .recipiendId(recipientId)
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .sendId(recipientId)
                .recipiendId(senderId)
                .build();

        repository.save(senderRecipient);
        repository.save(recipientSender);
        return chatId;
    }
}
