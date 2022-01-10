package com.project.questapp.controllers;

import com.project.questapp.entities.PostLike;
import com.project.questapp.requests.PostLikeRequest.RequestPostLikeCreate;
import com.project.questapp.services.PostLikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postLike")
public class PostLikeController {

    private PostLikeService postLikeService;

    public PostLikeController(PostLikeService postLikeService) {
        this.postLikeService = postLikeService;
    }

    @GetMapping
    public List<PostLike> isLikeUserIdPostId(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return postLikeService.isLikeUserIdPostId(userId, postId);
    }

    @PostMapping
    public PostLike createNewPostLike(@RequestBody RequestPostLikeCreate requestPostLikeCreate ){
        return postLikeService.createNewPostLike(requestPostLikeCreate);
    }

    @DeleteMapping("/{id}")
    public void deletePostLikeById(@PathVariable Long id){
        postLikeService.deletePostLikeById(id);
    }

}
