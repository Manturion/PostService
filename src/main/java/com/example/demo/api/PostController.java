package com.example.demo.api;

import com.example.demo.infrastructure.Post.PostDto;
import com.example.demo.infrastructure.Post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping()
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    @GetMapping
    @ResponseBody
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("{id}")
    @ResponseBody
    public PostDto getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping("/category")
    public List<PostDto> getPostsByCategory(@RequestParam String category) {
        return postService.getPostsByCategory(category);
    }

    @PutMapping("{id}")
    public Optional<PostDto> editPost(@RequestBody PostDto postDto, @PathVariable Long id) {
        return postService.editPost(postDto, id);
    }

    @DeleteMapping("{id}")
    public String deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

}
