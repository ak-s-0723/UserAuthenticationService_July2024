package org.example.userauthenticationservice_july2024.repos;

import org.example.userauthenticationservice_july2024.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findUserByEmail(String email);
}
