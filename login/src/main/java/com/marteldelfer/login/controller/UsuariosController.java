package com.marteldelfer.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marteldelfer.login.repository.UsuariosRepository;
import com.marteldelfer.login.models.Usuario;

@Controller
@RequestMapping("/")
public class UsuariosController {
    
    @Autowired
    private UsuariosRepository repo;


    @GetMapping({"","/"})
    public String mostraListaUsuarios(Model model) {
        List<Usuario> usuarios = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("usuarios", usuarios);
        return "usuarios/index";        
    }
}

