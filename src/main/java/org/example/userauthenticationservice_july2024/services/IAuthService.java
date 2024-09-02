package org.example.userauthenticationservice_july2024.services;

import org.example.userauthenticationservice_july2024.models.User;

public interface IAuthService {
    User signup(String email, String password);

    User login(String email,String password);

    User logout(String email);
}
