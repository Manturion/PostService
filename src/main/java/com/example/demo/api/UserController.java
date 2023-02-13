package com.example.demo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
