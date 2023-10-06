package com.dev.duodev.controller;


import com.dev.duodev.entity.User;
import com.dev.duodev.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/duodev/api/users")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public List<User> GetAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found on :: " + id));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@Validated @RequestBody User user) {
        User savedUser = userRepo.save(user);
        return ResponseEntity
                .created(URI.create("/duodev/api/users/" + savedUser.getId()))
                .body(savedUser);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(value = "id") long id) {
        userRepo.deleteById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") long id, @Validated @RequestBody User updatedUser) {
        User existingUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found on :: " + id));
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setStatus(updatedUser.getStatus());
        existingUser.setRole(updatedUser.getRole());
        existingUser.setProfilePicture(updatedUser.getProfilePicture());
        existingUser.setLastLoginDate(updatedUser.getLastLoginDate());
        User savedUser = userRepo.save(existingUser);
        return ResponseEntity.ok(savedUser);
    }

}


