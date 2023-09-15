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

import com.example.bobu.entity.Childeren;
import com.example.bobu.repository.ChilderenRepository;

@RequestMapping("/Childeren")
@RestController
@CrossOrigin(origins = "http://localhost:3000") //  react.js 3000 ports for cors policy

public class ChilderenController {

    private ChilderenRepository childerenRepository;

    public ChilderenController(ChilderenRepository childerenRepository){
        this.childerenRepository=childerenRepository;
    }
    @GetMapping
    public List<Childeren> getAllChilderen(){
        return childerenRepository.findAll();
    }
    @PostMapping
    public Childeren createChilderen(@RequestBody Childeren newChilderen){
        return childerenRepository.save(newChilderen);
    }
    @GetMapping("/{ChilderenID}")
    public Childeren getById(@PathVariable Long ChilderenID){
        return childerenRepository.findById(ChilderenID).orElse(null);
    }
    //update maxscreentime
    @PutMapping("/{ChilderenID}")
    public Childeren updateChilderenScreenTime(@PathVariable Long ChilderenID, @RequestBody Childeren newChilderen){
        Optional<Childeren> childeren= childerenRepository.findById(ChilderenID); 
        if(childeren.isPresent()){
            Childeren foundChilderen= childeren.get();
            foundChilderen.setMaxscreentime(newChilderen.getMaxscreentime());
            return childerenRepository.save(foundChilderen);
        }
        else return null;
    }
}
