package com.example.demo.infrastructure.Post;

import com.example.demo.domain.entities.UserEntity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PostDto {

    private Long id;
    private String category;
    private String title;
    private String content;
    @ManyToOne
    private UserEntity user;
}
