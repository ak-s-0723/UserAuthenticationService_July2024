package org.example.userauthenticationservice_july2024.controllers;

import org.example.userauthenticationservice_july2024.dtos.LoginRequestDto;
import org.example.userauthenticationservice_july2024.dtos.LogoutRequestDto;
import org.example.userauthenticationservice_july2024.dtos.SignupRequestDto;
import org.example.userauthenticationservice_july2024.dtos.UserDto;
import org.example.userauthenticationservice_july2024.models.User;
import org.example.userauthenticationservice_july2024.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
         if(signupRequestDto.getEmail() == null || signupRequestDto.getPassword() == null) {
             return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
         }

         User user = authService.signup(signupRequestDto.getEmail(),signupRequestDto.getPassword());
         return new ResponseEntity<>(from(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto loginRequestDto) {
       User user = authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
       return new ResponseEntity<>(from(user),HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<UserDto> logout(@RequestBody LogoutRequestDto logoutRequestDto) {
       //Learners need to implement after 6 sept
        return null;
    }

    private UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRole());
        return userDto;
    }
}
