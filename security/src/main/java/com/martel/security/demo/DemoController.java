package com.martel.security.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martel.security.token.Token;
import com.martel.security.token.TokenRepository;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private TokenRepository tokenRepository;
    
    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }
    @GetMapping("/tokens")
    public ResponseEntity<List<Token>> getAllTokens() {
        return ResponseEntity.ok(tokenRepository.findAll());
    }
}
