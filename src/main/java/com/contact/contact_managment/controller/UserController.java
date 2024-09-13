package com.contact.contact_managment.controller;

import com.contact.contact_managment.exception.UserNotFoundException;
import com.contact.contact_managment.model.User;
import com.contact.contact_managment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User addNewUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllusers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUserById(@PathVariable Long id,@RequestBody User newUser){
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setPhoneNumber(newUser.getPhoneNumber());
                    user.setPhoneNumber2(newUser.getPhoneNumber2());
                    user.setAddress(newUser.getAddress());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUserById(@PathVariable Long id){
        if (!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User id " + id + " deleted Successfully";
    }

}
