package com.martel.keycloak;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello user");
    }

    @GetMapping("/hello/admin")
    public ResponseEntity<String> helloAdmin() {
        return ResponseEntity.ok("Hello admin");
    }

}
