package org.example.userauthenticationservice_july2024.services;

import org.example.userauthenticationservice_july2024.models.User;
import org.example.userauthenticationservice_july2024.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User signup(String email, String password) {
        return null;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }

    @Override
    public User logout(String email) {
        return null;
    }
}
