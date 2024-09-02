package org.example.userauthenticationservice_july2024.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.userauthenticationservice_july2024.models.Role;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class UserDto {
    private String email;

    private Set<Role> roles = new HashSet<>();
}
