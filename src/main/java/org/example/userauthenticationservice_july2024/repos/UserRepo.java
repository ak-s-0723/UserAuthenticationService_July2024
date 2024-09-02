package org.example.userauthenticationservice_july2024.repos;

import org.example.userauthenticationservice_july2024.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
