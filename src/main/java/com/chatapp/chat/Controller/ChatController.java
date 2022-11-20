package com.chatapp.chat.Controller;

import com.chatapp.chat.Model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    //app/message
    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    private ChatMessage receivePublicMessage(@Payload ChatMessage message){
        return message;
    }

    @MessageMapping("/private-message")
    public ChatMessage receivePrivateMessage(@Payload ChatMessage message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message); // /user/username/private
        return message;
    }

}
