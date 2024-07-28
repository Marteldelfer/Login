package com.marteldelfer.login.models;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public class UsuarioDto {

    @NotEmpty(message = "Nome é obrigatório")
    private String nome;

    @NotEmpty(message = "Email é obrigatório")
    private String email;

    @NotEmpty(message = "Senha é obrigatória")
    private String senha;

    private MultipartFile imageFile;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
    

}
