package com.example.bobu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Parents")
public class Parent {
    @Id
    Long id;
    String name;
    String surname;
    String mail;
    String password;

    /* Örnek Parent json içeriği
     {
        "id": 1,
        "name": "Ali",
        "surname": "Kocaman",
        "mail": "Ali@gmail.com",
        "password": "12345"
    }
     */
}
