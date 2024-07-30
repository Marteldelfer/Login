package com.marteldelfer.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marteldelfer.login.models.Usuario;
import com.marteldelfer.login.models.UsuarioDto;
import com.marteldelfer.login.repository.UsuariosRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
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
    public String mostraTelaCadastro(Model model) {
        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuarioDto", usuarioDto);
        return "usuarios/TelaCadastro";
    }

    @PostMapping("/cadastro")
    public String criarConta(
        @Valid @ModelAttribute UsuarioDto usuarioDto,
        BindingResult result
    ) {

        if (result.hasErrors()) {
            return "usuarios/TelaCadastro";
        }

        return "redirect:/usuarios";
    }
}

