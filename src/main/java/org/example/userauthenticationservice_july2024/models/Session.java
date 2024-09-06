package org.example.userauthenticationservice_july2024.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Session extends BaseModel {

    private String token;

    @ManyToOne
    private User user;
}

//1            1
//session      user
//m              1
//
//
//m : 1
