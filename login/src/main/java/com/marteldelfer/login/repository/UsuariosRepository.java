package com.marteldelfer.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marteldelfer.login.models.Usuario;

public interface UsuariosRepository extends JpaRepository <Usuario, Integer> {
    
}
