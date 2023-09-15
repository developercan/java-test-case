package com.example.bobu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bobu.entity.Parent;
import com.example.bobu.repository.ParentRepository;

@RequestMapping("/Parents")
@RestController
@CrossOrigin(origins = "http://localhost:3000") //  react.js 3000 ports for cors policy

public class ParentController {

    private ParentRepository parentRepository;

    public ParentController(ParentRepository parentRepository){
        this.parentRepository=parentRepository;
    }
    @GetMapping
    public List<Parent> getAllUsers(){
        return parentRepository.findAll();
    }
    @PostMapping
    public Parent createParent(@RequestBody Parent newParent){
        return parentRepository.save(newParent);
    }
    @GetMapping("/{ParentID}")
    public Parent getById(@PathVariable Long ParentID){
        return parentRepository.findById(ParentID).orElse(null);
    }
    //update
    @PutMapping("/{ParentID}")
    public Parent updateUserAge(@PathVariable Long ParentID, @RequestBody Parent newParent){
        Optional<Parent> parent= parentRepository.findById(ParentID); 
        if(parent.isPresent()){
            Parent foundParent= parent.get();
            foundParent.setName(newParent.getName());
            foundParent.setSurname(newParent.getSurname());
            foundParent.setPassword(newParent.getPassword());
            foundParent.setMail(newParent.getMail());
            return parentRepository.save(foundParent);
        }
        else return null;
    }
}
