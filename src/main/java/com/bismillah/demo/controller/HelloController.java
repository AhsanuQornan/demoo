package com.bismillah.demo.controller;


import com.bismillah.demo.entity.User;
import com.bismillah.demo.service.UserDAO;
import com.bismillah.demo.service.UserRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class HelloController {
    @Autowired
    private UserRepositoy userRepo;
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World";
    }

    @GetMapping("/hellopakehtml")
    public String helloHtml(){
        return "<h1 style='color :pink;'> I LOVE ALLAH and Rasulullah<h1>";
    }

    @GetMapping("/alluser")
    public List<User> getAllUser() {
        return userRepo.findAll();
    }


    @GetMapping("/findbyusername")
    public User getuser(@RequestParam String username) {

        return userRepo.findbyusername(username);
    }


    @GetMapping("/getbyUsername")
    public ResponseEntity<User> getbyUsername(@RequestParam String username) {

        User u = userDAO.getbyUsername(username);
        if (u != null) {
            return new ResponseEntity<>(userDAO.getbyUsername(username), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveuser(@RequestBody User user){
        User u= userRepo.save(user);
        return new ResponseEntity<>(u,HttpStatus.CREATED);

    }

}
