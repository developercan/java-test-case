package com.example.bobu.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Childerens")
@Data
public class Childeren {
    @Id
    Long id;
    Long Parentid;
    Long Userid;
    int maxscreentime;


    
}
