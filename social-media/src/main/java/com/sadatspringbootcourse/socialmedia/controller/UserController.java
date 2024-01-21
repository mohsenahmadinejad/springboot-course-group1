package com.sadatspringbootcourse.socialmedia.controller;


import com.sadatspringbootcourse.socialmedia.User;
import com.sadatspringbootcourse.socialmedia.exception.UserNotFoundException;
import com.sadatspringbootcourse.socialmedia.repository.UserRepository;
import com.sadatspringbootcourse.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
   // Retrieve all Users

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
//        return  userRepository.users;
        return  ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

//    Create a User
    @PostMapping("/users")
    public  ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user) );
    }

//    Retrieve one User
    @GetMapping("/users/{id}") // -> /users/1
    public ResponseEntity<User> getUserById(@PathVariable  Integer id){
        User user=userService.getUserById(id);
        if (user==null){
            throw new UserNotFoundException("id: "+id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(user );
    }
//    Delete a User
    @DeleteMapping("/users/{id}")// -> /users/1
    public ResponseEntity<Void> deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
