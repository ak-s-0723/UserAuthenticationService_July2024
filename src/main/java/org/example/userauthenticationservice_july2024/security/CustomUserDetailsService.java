package org.example.userauthenticationservice_july2024.security;

import org.example.userauthenticationservice_july2024.models.User;
import org.example.userauthenticationservice_july2024.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepo.findUserByEmail(email);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("user not present");
        }

        User user = optionalUser.get();
        return new CustomUserDetails(user);
    }
}
