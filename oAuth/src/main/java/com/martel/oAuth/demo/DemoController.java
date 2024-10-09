package com.martel.oAuth.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoController {

    @GetMapping("/")
    public ResponseEntity<String> getMethodName() {
        return ResponseEntity.ok("Hello World");
    }
    
}