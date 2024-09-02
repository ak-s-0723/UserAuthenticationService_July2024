package org.example.userauthenticationservice_july2024.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Role extends BaseModel {
    private String value;
}

//m         1
//user    role
// 1      m
//
//m   :   m
