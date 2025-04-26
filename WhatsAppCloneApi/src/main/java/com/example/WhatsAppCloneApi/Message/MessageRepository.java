package com.example.WhatsAppCloneApi.Message;

import com.example.WhatsAppCloneApi.Chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(name = MessageConstants.FIND_MESSAGES_BY_CHAT_ID)
    List<Message> findMessagesByChatId(@Param("chatId") String chatId);
@Query(name = MessageConstants.SET_MESSAGES_TO_SEEN_BY_CHAT)
@Modifying
    void setMessagesToSeenByChatId(@Param("chatId") String chatIs,@Param("newState") MessageState state);


}
