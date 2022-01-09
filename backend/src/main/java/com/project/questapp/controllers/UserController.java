package com.project.questapp.controllers;

import com.project.questapp.entities.User;
import com.project.questapp.services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userServices.createUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        return userServices.getOneUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser){
        return userServices.updateOneUser(userId,newUser);
    }

    @DeleteMapping("/{userId}")
    public Boolean deteleOneUser(@PathVariable Long userId){
        return userServices.deleteUserById(userId);
    }
}
