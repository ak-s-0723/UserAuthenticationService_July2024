package org.example.userauthenticationservice_july2024.mappers;

import org.example.userauthenticationservice_july2024.dtos.UserDto;
import org.example.userauthenticationservice_july2024.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends EntityMapper<UserDto, User> {
}
