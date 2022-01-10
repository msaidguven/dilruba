package com.project.questapp.controllers;

import com.project.questapp.entities.Post;
import com.project.questapp.requests.PostRequest.PostCreateRequest;
import com.project.questapp.requests.PostRequest.PostUpdateRequest;
import com.project.questapp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPost(@RequestParam Optional<Long> userId){
        return postService.getAllPost(userId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest){
        return postService.createOnePostById(newPostRequest);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updateOnePostById(postId, postUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deleteOnePostById(postId);
    }


}
