package com.example.handmadeshopping.service;

import EJB.model.User;
import com.example.handmadeshopping.repository.UserRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless // Sau @ApplicationScoped, @Dependent, etc.
public class UserService {

    @Inject
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void registerUser(User user) {
        userRepository.saveUser(user);
    }
}