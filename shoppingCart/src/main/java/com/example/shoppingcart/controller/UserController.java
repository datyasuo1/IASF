package com.example.shoppingcart.controller;


import com.example.shoppingcart.entity.User;
import com.example.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getList(){
        return ResponseEntity.ok(userService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }
    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<User> optionalUser =  userService.findById(id);
        if (!optionalUser.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalUser.get());
    }

    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody User updateUser){
        Optional<User> optionalUser =  userService.findById(id);
        if (!optionalUser.isPresent()){
            ResponseEntity.badRequest().build();
        }
        User user = optionalUser.get();
        user.setUsername(updateUser.getUsername());
        user.setPassword(updateUser.getPassword());
        user.setImage(updateUser.getImage());
        user.setStatus(updateUser.getStatus());
        return ResponseEntity.ok(userService.save(user));
    }

    @RequestMapping(method = RequestMethod.PUT,path = "delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        Optional<User> optionalUser =  userService.findById(id);
        if (!optionalUser.isPresent()){
            ResponseEntity.badRequest().build();
        }
        User user = optionalUser.get();
        if (user.getStatus() == -1){
            ResponseEntity.badRequest().build();
        }
        user.setStatus(-1);
        return ResponseEntity.ok(userService.save(user));
    }

}
