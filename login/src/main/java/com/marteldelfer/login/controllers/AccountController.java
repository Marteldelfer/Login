package com.marteldelfer.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.marteldelfer.login.models.RegisterDto;
import com.marteldelfer.login.repositories.AppUserRepository;

@Controller
public class AccountController {
    
    @Autowired
    private AppUserRepository repo;

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute(registerDto);
        return "register";
    }
}
