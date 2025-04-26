package com.example.WhatsAppCloneApi.Message;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private String content;
    private String senderID;
    private String receiverID;
    private MessageType type;
    private String chatID;

}
