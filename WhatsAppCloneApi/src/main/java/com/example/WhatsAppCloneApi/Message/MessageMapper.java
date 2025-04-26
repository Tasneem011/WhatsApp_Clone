package com.example.WhatsAppCloneApi.Message;

import org.springframework.stereotype.Service;

@Service
public class MessageMapper {
    public MessageResponse toMessageResponse(Message message) {
        return MessageResponse.builder()
                .id(message.getId())
                .content(message.getContent())
                .type(message.getType())
                .state(message.getState())
                .senderId(message.getSenderId())
                .receiverId(message.getRecieverId())
                .createdAt(message.getCreatedDate())
                .build();
    }
}
