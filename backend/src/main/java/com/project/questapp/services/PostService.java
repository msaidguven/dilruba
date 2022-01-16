package com.project.questapp.services;

import com.project.questapp.entities.Menu;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repository.PostRepository;
import com.project.questapp.requests.PostRequest.PostCreateRequest;
import com.project.questapp.requests.PostRequest.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;
    private MenuService menuService;


    public PostService(PostRepository postRepository, UserService userService, MenuService menuService) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.menuService = menuService;
    }

    public List<Post> getAllPost(Optional<Long> userId){
        if (userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }else {
            return postRepository.findAll();
        }
    }

    public Post createOnePostById(PostCreateRequest newPostRequest){
        User user = userService.getOneUserById(newPostRequest.getUserId());
        Menu menu = menuService.getOneMenuById(newPostRequest.getDersId());
        if(user == null || menu == null)
            return null;
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setPostContent(newPostRequest.getPostContent());
        toSave.setKonuId(newPostRequest.getKonuId());
        toSave.setProperty(newPostRequest.getProperty());
        toSave.setDCevap(newPostRequest.getDCevap());
        toSave.setMenu(menu);
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setPostContent(postUpdateRequest.getPostContent());
            return postRepository.save(toUpdate);
        }
        return null;

    }

    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
