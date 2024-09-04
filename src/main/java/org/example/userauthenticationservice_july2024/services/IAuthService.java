package org.example.userauthenticationservice_july2024.services;

import org.antlr.v4.runtime.misc.Pair;
import org.example.userauthenticationservice_july2024.exceptions.InvalidCredentialsException;
import org.example.userauthenticationservice_july2024.exceptions.UserAlreadyExistsException;
import org.example.userauthenticationservice_july2024.models.User;
import org.springframework.util.MultiValueMap;

public interface IAuthService {
    User signup(String email, String password) throws UserAlreadyExistsException;

    Pair<User, MultiValueMap<String,String>> login(String email, String password) throws InvalidCredentialsException;

    User logout(String email);
}
