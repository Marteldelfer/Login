package com.marteldelfer.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marteldelfer.login.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
    
    public AppUser findByEmail(String email);
}
