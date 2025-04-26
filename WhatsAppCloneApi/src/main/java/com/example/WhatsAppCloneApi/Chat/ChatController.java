package com.example.WhatsAppCloneApi.Chat;

import com.example.WhatsAppCloneApi.common.StringResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chats")
@RequiredArgsConstructor
@Tag(name = "Chat")
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<StringResponse> createchat(@RequestParam(name = "sender_id") String sender_id,
                                                     @RequestParam(name = "reciever_id") String reciever_id)
    {
        final String chat_id = chatService.createChat(sender_id, reciever_id);
        StringResponse response = StringResponse.builder().response(chat_id).build();
        return  ResponseEntity.ok(response);

    }
@GetMapping
    public ResponseEntity<List<ChatResponse>> getChatsByReciever(Authentication auth){
        return ResponseEntity.ok(chatService.getChatsByReceiverId(auth));
}


}
