package org.example.userauthenticationservice_july2024.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ValidateTokenDto {
    private String token;
    private Long userId;
}
