package com.example.ChatSystem.Repository;


import com.example.ChatSystem.Entity.Message;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByRoomId(String roomId);
    List<Message> findBySenderAndRecipient(String sender, String recipient);
}

