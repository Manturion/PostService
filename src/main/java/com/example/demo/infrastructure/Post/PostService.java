package com.example.demo.infrastructure.Post;

import com.example.demo.domain.entities.PostEntity;
import com.example.demo.domain.mappers.PostMapper;
import com.example.demo.domain.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostDto createPost(PostDto postDto){
        postRepository.save(postMapper.mapToEntity(postDto));
        return postDto;
    }

    public Optional<List<PostDto>> getAllPosts(){
        List<PostEntity> postEntity = postRepository.findAll();
        return Optional.of(postMapper.mapListToDto(postRepository.findAll()));
    }

    public Optional<PostDto> getPostById(Long id){
        PostEntity postEntity = postRepository.getById(id);
        return Optional.of(postMapper.mapToDto(postEntity));
    }

    public List<PostDto> getPostsOfUser(){

    }

    public List<PostDto> getPostsByCategory(){

    }

    public String deletePost(Long id){

    }

    public PostDto editPost(PostDto postDto, Long id){

    }

}
