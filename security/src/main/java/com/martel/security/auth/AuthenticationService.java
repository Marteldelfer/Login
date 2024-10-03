package com.martel.security.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.martel.security.config.JwtService;
import com.martel.security.user.AppUser;
import com.martel.security.user.Role;
import com.martel.security.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
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
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
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
        
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }

}
