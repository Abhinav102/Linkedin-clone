package com.kodem.demo.linkedin.userModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create
    public void createUser(User user) {
        userRepository.save(user);
    }

    // Retrieve
    public User getUser(String username) {
        return userRepository.findByUsername(username).get();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update
    public void updateUser(User updatedUser, String username) {
        User oldUser = userRepository.findByUsername(username).get();
        updatedUser.setId(oldUser.getId());
        userRepository.save(updatedUser);
    }

    // Delete
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username).get();
        userRepository.delete(user);
    }

}
