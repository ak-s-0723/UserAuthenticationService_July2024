package org.example.userauthenticationservice_july2024.services;

import org.example.userauthenticationservice_july2024.models.User;
import org.example.userauthenticationservice_july2024.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User getUser(Long id) {
        return userRepo.findById(id).get();
    }
}
