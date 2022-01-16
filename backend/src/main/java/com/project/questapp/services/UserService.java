package com.project.questapp.services;

import com.project.questapp.entities.User;
import com.project.questapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser){
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setUserPassword(newUser.getUserPassword());
            foundUser.setUserEmail(newUser.getUserEmail());
            return userRepository.save(foundUser);
        }else {
            return null;
        }
    }

    public Boolean deleteUserById(Long userId){
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            userRepository.deleteById(userId);
            return true;
        }else {
            return false;
        }
    }


}
