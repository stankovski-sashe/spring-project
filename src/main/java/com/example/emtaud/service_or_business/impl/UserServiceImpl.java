package com.example.emtaud.service_or_business.impl;

import com.example.emtaud.model.User;
import com.example.emtaud.model.exception.UserNotFoundException;
import com.example.emtaud.persistence_or_repository.UserRepository;
import com.example.emtaud.service_or_business.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(String userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }
}
