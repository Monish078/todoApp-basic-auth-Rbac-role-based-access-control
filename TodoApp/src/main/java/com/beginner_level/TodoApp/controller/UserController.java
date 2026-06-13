package com.beginner_level.TodoApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos/user")  // ye admin and user koi bhi access kar sakta hai authorization
public class UserController {  // USER API test ke liye

    @GetMapping("/dashboard")
    public String userDashboard() {
        return "User Dashboard";
    }

}
