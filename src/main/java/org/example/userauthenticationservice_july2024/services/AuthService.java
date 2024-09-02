package org.example.userauthenticationservice_july2024.services;

import org.example.userauthenticationservice_july2024.exceptions.UserAlreadyExistsException;
import org.example.userauthenticationservice_july2024.models.State;
import org.example.userauthenticationservice_july2024.models.User;
import org.example.userauthenticationservice_july2024.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User signup(String email, String password) throws UserAlreadyExistsException {
        Optional<User> userOptional = userRepo.findUserByEmail(email);
        if(userOptional.isPresent()) {
            throw new UserAlreadyExistsException("Email already registered !!");
        }

        User user = new User();

        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setState(State.ACTIVE);
        userRepo.save(user);
        return user;
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
