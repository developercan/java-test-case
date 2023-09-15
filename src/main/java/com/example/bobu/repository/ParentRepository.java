package com.example.bobu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bobu.entity.Parent;

public interface ParentRepository extends JpaRepository <Parent, Long> {
    
}
