package com.carterdboyle.store.controllers;

import com.carterdboyle.store.dtos.UserDto;
import com.carterdboyle.store.entities.User;
import com.carterdboyle.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<UserDto> getAllUsers() {
       return userRepository.findAll()
               .stream()
               .map(u -> new UserDto(u.getId(), u.getName(), u.getEmail()))
               .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
       var user = userRepository.findById(id).orElse(null);
       if (user == null) {
           // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           return ResponseEntity.notFound().build();
       }

       //return new ResponseEntity<>(user, HttpStatus.OK);
        var userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
        return ResponseEntity.ok(userDto);
    }

}
