package org.example.userauthenticationservice_july2024.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class User extends BaseModel {
    private String email;

    private String password;

    @ManyToMany
    private Set<Role> role = new HashSet<>();
}
