package com.example.ChatSystem.Service;


import com.example.ChatSystem.Entity.User;
import com.example.ChatSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User joinRoom(String userId, String roomId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && !user.getRooms().contains(roomId)) {
            user.getRooms().add(roomId);
            userRepository.save(user);
        }
        return user;
    }
}

