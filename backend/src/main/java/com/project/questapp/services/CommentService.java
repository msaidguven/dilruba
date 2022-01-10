package com.project.questapp.services;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repository.CommentRepository;
import com.project.questapp.requests.CommentRequest.CommentCreateRequest;
import com.project.questapp.requests.CommentRequest.CommentUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private PostService postService;
    private UserService userService;

    public CommentService(CommentRepository commentRepository, PostService postService, UserService userService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.userService = userService;
    }

    public List<Comment> getAllComments(@RequestParam Optional<Long> postId, @RequestParam Optional<Long> userId) {
        if (postId.isPresent() && userId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else {
            return commentRepository.findAll();
        }
    }

    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.getOneUserById(commentCreateRequest.getUserId());
        Post post = postService.getOnePostById(commentCreateRequest.getPostId());
        if (user != null && post != null) {
            Comment commentToSave = new Comment();
            commentToSave.setId(commentCreateRequest.getId());
            commentToSave.setCommentContent(commentCreateRequest.getCommentContent());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            return commentRepository.save(commentToSave);
        } else {
            return null;
        }
    }

    public Comment getOneCommentById(Long id){
        return commentRepository.findById(id).orElse(null);
    }

    public Comment updateCommentById(Long id, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            Comment toUpdate = comment.get();
            toUpdate.setCommentContent(commentUpdateRequest.getCommentContent());
            return commentRepository.save(toUpdate);
        }
        return null;
    }

    public void deleteOneCommentById(@PathVariable Long id) {
        commentRepository.deleteById(id);
    }


}
