package com.example.bobu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bobu.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
