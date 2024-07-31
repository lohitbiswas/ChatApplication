package com.example.ChatSystem.Controller;

import com.example.ChatSystem.Entity.Message;
import com.example.ChatSystem.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages(@RequestParam String roomId) {
        return messageService.getAllMessages(roomId);
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable String id) {
        return messageService.getMessageById(id);
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable String id) {
        messageService.deleteMessage(id);
    }

}
