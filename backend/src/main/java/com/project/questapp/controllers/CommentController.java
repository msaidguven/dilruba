package com.project.questapp.controllers;

import com.project.questapp.entities.Comment;
import com.project.questapp.requests.CommentRequest.CommentCreateRequest;
import com.project.questapp.requests.CommentRequest.CommentUpdateRequest;
import com.project.questapp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> postId, @RequestParam Optional<Long> userId){
        return commentService.getAllComments(postId, userId);
    }

    @GetMapping("/comment/{id}") // ---> /comments/comment/{id}
    public Comment getOneCommentById(@PathVariable Long id){
        return commentService.getOneCommentById(id);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest newComment){
        return commentService.createOneComment(newComment);
    }

    @PutMapping("/update/{id}") // ---> /comments/update/{id}
    public Comment updateCommentById(@PathVariable Long id, @RequestBody CommentUpdateRequest commentUpdateRequest){
        return commentService.updateCommentById(id, commentUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteOneCommentById(@PathVariable Long id){
        commentService.deleteOneCommentById(id);
    }



}
