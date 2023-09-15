package com.example.bobu.Services;

import com.example.bobu.entity.User;

import java.util.List;
import java.util.Optional;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bobu.repository.UserRepository;

@Service
public class UserService {
    UserRepository userRepository;
    //        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User saveUser(User user){

       /*  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        final String encryptedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encryptedPassword);
        return userService.saveUser(newUser);*/

        // yukarıdaki ufak işlemle db ye hashlenmiş password aktarılıyor ancak spring security'de sorun yaşadığım için şu anda çalışmıyor
        return userRepository.save(user);
    }
     public User getOneUser(@PathVariable Long UserID){
        return userRepository.findById(UserID).orElse(null);
    }

     public User updateUser(@PathVariable Long UserID, @RequestBody User newUser){
        Optional<User> user= userRepository.findById(UserID);
        if(user.isPresent()){
            User foundUser= user.get();
            foundUser.setName(newUser.getName());
            foundUser.setSurname(newUser.getSurname());
            foundUser.setPassword(newUser.getPassword());
            foundUser.setAge(newUser.getAge());
            foundUser.setMail(newUser.getMail());
            return userRepository.save(foundUser);
        }
        else return null;
    }
}
