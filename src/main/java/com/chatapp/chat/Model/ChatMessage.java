package com.chatapp.chat.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatMessage {

    private String senderName;
    private String receiverName;
    private String messageContent;
    private String date;
    private StatusEnum status;
}
