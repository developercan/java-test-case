package com.example.bobu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String mail;
    String password;
    int age;
    
    /* örnek psotman json içeriği
     * 
       {
        "id": 1,
        "name": "Ahmet Can",
        "surname": "Kocaman",
        "mail": "Ahmet@gmail.com",
        "password": "12345",
        "age": 24
    }
     */
}
