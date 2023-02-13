package com.example.demo.infrastructure.Post;

import com.example.demo.domain.entities.PostEntity;
import com.example.demo.domain.entities.UserEntity;
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

    private Long userId;

    public static PostEntity mapToEntity(PostDto postDto, UserEntity user){
        PostEntity post = new PostEntity();
        post.setContent(postDto.getContent());
        post.setCategory(postDto.getCategory());
        post.setTitle(postDto.getTitle());
        post.setUser(user);
        return post;
    }

    public PostDto(PostEntity postEntity){
        this.id = postEntity.getId();
        this.content = postEntity.getContent();
        this.title = postEntity.getTitle();
        this.category = postEntity.getCategory();
        this.userId = postEntity.getUser().getId();
    }

}
