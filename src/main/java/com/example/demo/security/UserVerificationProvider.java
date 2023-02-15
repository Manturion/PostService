package com.example.demo.security;

import com.example.demo.domain.entities.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class UserVerificationProvider {

    public static void compabilityVerificator(Long id){
        UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long loggedInUser = userEntity.getId();
        if(!Objects.equals(loggedInUser, id)){
            throw new IllegalArgumentException("id of logged in user is not the same as given");
        }
    }

}
