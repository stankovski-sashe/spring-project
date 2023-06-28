package com.example.emtaud.service_or_business;

import com.example.emtaud.model.User;

public interface AuthService {
    User getCurrentUser();
    String getCurrentUserId();
}
