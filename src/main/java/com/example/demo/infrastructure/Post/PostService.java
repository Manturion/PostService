package com.example.demo.infrastructure.Post;

import com.example.demo.domain.entities.PostEntity;
import com.example.demo.domain.entities.UserEntity;
import com.example.demo.domain.repositories.PostRepository;
import com.example.demo.security.UserVerificationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostDto createPost(PostDto postDto) {
        UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PostEntity post = PostDto.mapToEntity(postDto, userEntity);
        postRepository.save(post);
        return postDto;
    }

    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream().map(PostDto::new).toList();
    }

    public PostDto getPostById(Long id) {
        PostEntity post = postRepository.findById(id).orElseThrow();
        return new PostDto(post);
    }

    public List<PostDto> getPostsByCategory(String category) {
        return postRepository.getPostsByCategory(category).stream().map(PostDto::new).toList();
    }

    public String deletePost(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow();
        UserVerificationProvider.checkPostAuthor(postEntity);
        postRepository.deleteById(id);
        return "Post which id is " + id + " was deleted succesfully";
    }

    public Optional<PostDto> editPost(PostDto postDto, Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow();
        UserVerificationProvider.checkPostAuthor(postEntity);
        return postRepository.findById(id).map((post -> {
            post.setTitle(postDto.getTitle());
            post.setCategory(postDto.getCategory());
            post.setContent(postDto.getContent());
            postRepository.save(post);
            return null;
        }));

    }

}
