package com.example.WhatsAppCloneApi.Chat;


import com.example.WhatsAppCloneApi.User.UserRepository;
import com.example.WhatsAppCloneApi.User.user;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final ChatMapper mapper;


    @Transactional(readOnly = true)
    public List<ChatResponse> getChatsByReceiverId(Authentication currentUser) {
        final String userId = currentUser.getName();
        return chatRepository.findChatsBySenderId(userId)
                .stream()
               // .map(c->mapper.toChatResponse(c,userId))
                .toList();
    }


    public String createChat(String senderId, String receiverId) {

        Optional<Chat> existingChat = chatRepository.findChatsByReceiverAndSender(senderId, receiverId);
        if (existingChat.isPresent()) {
            return existingChat.get().getId();
        }

        user sender = userRepository.findByPublicId(senderId)
                .orElseThrow(() ->  new EntityNotFoundException("User with id " + senderId + " not found"));
        user receiver = userRepository.findByPublicId(receiverId)
                .orElseThrow(() ->  new EntityNotFoundException("User with id " + receiverId + " not found"));

        Chat chat = new Chat();
        chat.setSender(sender);
        chat.setRecipient(receiver);

        Chat savedChat = chatRepository.save(chat);
        return savedChat.getId();
    }
}
