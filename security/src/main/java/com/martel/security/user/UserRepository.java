package com.martel.security.user;

import java.util.UUID;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, UUID>{
    
    public Optional<AppUser> findByEmail(String email);
    
}
