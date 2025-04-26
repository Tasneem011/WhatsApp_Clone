package com.example.WhatsAppCloneApi.Chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat,String> {
    @Query(name = ChatConstants.FIND_CHAT_BY_SENDER_ID)
    List<ChatResponse> findChatsBySenderId(@Param("senderId")String userId);
    @Query(name = ChatConstants.FIND_CHAT_BY_SENDER_ID_AND_RECEIVER)
    Optional<Chat> findChatsByReceiverAndSender(@Param("senderId") String senderId, @Param("recepientId") String receiverId);
}
