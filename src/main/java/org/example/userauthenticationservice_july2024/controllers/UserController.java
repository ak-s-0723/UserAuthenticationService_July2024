package org.example.userauthenticationservice_july2024.controllers;

import org.example.userauthenticationservice_july2024.dtos.UserDto;
import org.example.userauthenticationservice_july2024.models.User;
import org.example.userauthenticationservice_july2024.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
       User user = userService.getUser(id);
        System.out.println(user.getEmail());
        return from(user);
    }

    private UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setRoles(null);
        return userDto;
    }


}
