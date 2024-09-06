package org.example.userauthenticationservice_july2024.repos;

import org.example.userauthenticationservice_july2024.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepo extends JpaRepository<Session,Long> {
    Optional<Session> findByTokenAndUser_Id(String token, Long userId);
}
