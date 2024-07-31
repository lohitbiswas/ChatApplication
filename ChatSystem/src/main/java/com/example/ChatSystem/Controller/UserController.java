package com.example.ChatSystem.Controller;

import com.example.ChatSystem.Entity.User;
import com.example.ChatSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/rooms/{roomId}")
    public User joinRoom(@RequestParam String userId, @PathVariable String roomId) {
        return userService.joinRoom(userId, roomId);
    }
}

