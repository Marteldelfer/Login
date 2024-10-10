package com.martel.security.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.martel.security.config.JwtService;
import com.martel.security.token.Token;
import com.martel.security.token.TokenRepository;
import com.martel.security.token.TokenType;
import com.martel.security.user.AppUser;
import com.martel.security.user.Role;
import com.martel.security.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    public AuthenticationResponse register(RegisterRequest request) {
        AppUser user = AppUser.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
        AppUser savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        revokeAllUserTokens(savedUser);
        saveUserToken(savedUser, jwtToken);
        
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            request.getEmail(),
             request.getPassword())
             );
        var user = repository.findByEmail(request.getEmail())
            .orElseThrow();
        var jwtToken = jwtService.generateToken(user); 

        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);   
        
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }

    private void revokeAllUserTokens(AppUser user) {
        var validTokens = tokenRepository.findAllValidTokensByUser(user.getId());
        if (validTokens.isEmpty()) {
            return;
        }
        validTokens.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validTokens);
    }

    private void saveUserToken(AppUser user, String jwtToken) {
        var token = Token.builder()
            .user(user)
            .token(jwtToken)
            .type(TokenType.BEARER)
            .expired(false)
            .revoked(false)
            .build();
        tokenRepository.save(token);
    }

}
