package com.example.crud.controller;

import com.example.crud.domain.user.PostRequestUser;
import com.example.crud.domain.user.PutRequestUser;
import com.example.crud.domain.user.User;
import com.example.crud.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity getAllUsers(){
        var allUsers = repository.findAll();
        return ResponseEntity.ok(allUsers);
    };

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid PostRequestUser data){
        User userEntity = new User(data);
        repository.save(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    };

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable UUID id, @RequestBody @Valid PutRequestUser data){
        Optional<User> optionalUserEntity = repository.findById(id);
        if (optionalUserEntity.isPresent()) {
            User userEntity = optionalUserEntity.get();
            if (data.name() != null) {
                userEntity.setName(data.name());
            }
            if (data.email() != null) {
                userEntity.setEmail(data.email());
            }
            if (data.age() != null) {
                userEntity.setAge(data.age());
            }
            repository.save(userEntity);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        Optional<User> optionalUserEntity = repository.findById(id);
        if (optionalUserEntity.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
