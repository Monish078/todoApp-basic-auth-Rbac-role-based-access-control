package com.beginner_level.TodoApp;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest

class TodoAppApplicationTests {


    @Autowired
    private  PasswordEncoder encoder;


    @Test
    public void testPasswordEncoder(){
        System.out.println(encoder.encode("8384"));
    }

}
