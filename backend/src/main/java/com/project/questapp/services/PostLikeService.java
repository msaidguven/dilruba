package com.project.questapp.services;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.PostLike;
import com.project.questapp.entities.User;
import com.project.questapp.repository.PostLikeRepository;
import com.project.questapp.requests.PostLikeRequest.RequestPostLikeCreate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostLikeService {

    private PostLikeRepository postLikeRepository;
    private UserService userService;
    private PostService postService;

    public PostLikeService(PostLikeRepository postLikeRepository, UserService userService, PostService postService) {
        this.postLikeRepository = postLikeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<PostLike> isLikeUserIdPostId(Optional<Long> userId, Optional<Long> postId){
        if (userId.isPresent() && postId.isPresent()){
            return postLikeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }else if (userId.isPresent()){
            return postLikeRepository.findByUserId(userId.get());
        }else if (postId.isPresent()){
            return postLikeRepository.findByPostId(postId.get());
        }
        return postLikeRepository.findAll();
    }

    public PostLike createNewPostLike(RequestPostLikeCreate requestPostLikeCreate){
        User user = userService.getOneUserById(requestPostLikeCreate.getUserId());
        Post post = postService.getOnePostById(requestPostLikeCreate.getPostId());

        if (user != null && post != null){
            PostLike postLikeToSave = new PostLike();
            postLikeToSave.setId(requestPostLikeCreate.getId());
            postLikeToSave.setPost(post);
            postLikeToSave.setUser(user);
            return postLikeRepository.save(postLikeToSave);
        }else
            return null;
    }


    public void deletePostLikeById(Long id) {
        postLikeRepository.deleteById(id);
    }
}
