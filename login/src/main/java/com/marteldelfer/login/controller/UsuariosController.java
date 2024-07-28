package com.marteldelfer.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marteldelfer.login.models.Usuario;
import com.marteldelfer.login.models.UsuarioDto;
import com.marteldelfer.login.repository.UsuariosRepository;

@Controller
@RequestMapping("/")
public class UsuariosController {
    
    @Autowired
    private UsuariosRepository repo;

    @GetMapping({"","/"})
    public String mostraListaUsuarios(Model model) {
        List<Usuario> usuarios = repo.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/index";   
    }

    @GetMapping("/cadastro")
    public String mostraTelaLogin(Model model) {
        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuarioDto", usuarioDto);
        return "usuarios/TelaCadastro";
    }
}

