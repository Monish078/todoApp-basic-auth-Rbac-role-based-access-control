package com.beginner_level.TodoApp.controller;

import com.beginner_level.TodoApp.dto.UserRequest;
import com.beginner_level.TodoApp.entity.Role;
import com.beginner_level.TodoApp.entity.User;
import com.beginner_level.TodoApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos/auth")
@RequiredArgsConstructor
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @GetMapping("/public")
    public String publicApi() {
        return "Public API hai";
    }

    @PostMapping("/register")  // new user register
    public String register(@RequestBody UserRequest request) {

        User user = new User();  // ek new user object banaya jisse hum save karenge db mai
        user.setUsername(request.username());

        user.setPassword(passwordEncoder.encode(request.password())); // password encode me save karo

//        user.setRole(Role.USER);  // default role  USER set akrrhe hai sab me
        user.setRole(Role.valueOf(request.role()));

        userRepository.save(user);

        return "User Registered";
    }
}
