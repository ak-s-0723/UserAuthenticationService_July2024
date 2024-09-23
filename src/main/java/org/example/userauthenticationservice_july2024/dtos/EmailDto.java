package org.example.userauthenticationservice_july2024.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailDto {
    String to;
    String from;
    String subject;
    String body;
}
