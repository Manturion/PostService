package com.example.demo.security;

import com.example.demo.domain.entities.PostEntity;
import com.example.demo.domain.entities.UserEntity;
import com.example.demo.domain.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class UserVerificationProvider {

    private static PostRepository postRepository;

    public static void compabilityVerificator(Long id){
        UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long loggedInUser = userEntity.getId();
        if(!Objects.equals(loggedInUser, id)){
            throw new IllegalArgumentException("id of logged in user is not the same as given");
        }
    }

    public static void checkPostAuthor(PostEntity postEntity){
        UserEntity loggedInUser = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!Objects.equals(postEntity.getUser().getId(), loggedInUser.getId())){
            throw new IllegalArgumentException("post doesn't belong to user");
        }
    }

}
