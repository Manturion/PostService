package com.example.demo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {


    public ResponseEntity<?> createAuthToken(){
        return ResponseEntity.ok("");
    }

    public String createUser(){
        return "";
    }

}
