package com.martel.security.token;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, UUID>{
    
    @Query("""
            select t from Token t inner join AppUser u on t.user.id = u.id
            where u.id = :userId and (t.expired = false or t.revoked = false)
        """)
    List<Token> findAllValidTokensByUser(UUID userId);

    Optional<Token> findByToken(String token);
}
