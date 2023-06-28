package com.example.emtaud.service_or_business.impl;

import com.example.emtaud.model.User;
import com.example.emtaud.persistence_or_repository.UserRepository;
import com.example.emtaud.service_or_business.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getCurrentUser() {
//        User user =  this.userRepository.getOne("emt-user");
//        if (user == null) {
//            user = new User();
//            user.setUsername("emt-user");
//            return this.userRepository.save(user);
//        }

        return this.userRepository.findById("emt-user")
                .orElseGet(() -> {
                    User user = new User();
                    user.setUsername("emt-user");
                    return this.userRepository.save(user);
                });

    }

    @Override
    public String getCurrentUserId() {
        return this.getCurrentUser().getUsername();
    }
}
