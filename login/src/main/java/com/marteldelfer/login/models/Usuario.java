package com.marteldelfer.login.models;

import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "usuarios")
public class Usuario {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String senha;
    private Date criadoEm;
    private String imagemNome;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public Date getCriado() {
        return criadoEm;
    }
    public void setCriado(Date criadoEm) {
        this.criadoEm = criadoEm;
    }
    public String getImagemNome() {
        return imagemNome;
    }
    public void setImagemNome(String imagemNome) {
        this.imagemNome = imagemNome;
    }

    
}
