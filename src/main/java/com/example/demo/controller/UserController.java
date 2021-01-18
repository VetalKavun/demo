package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repo.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return (List<User>) userRepo.findAll();
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        userRepo.save(user);
    }
}
