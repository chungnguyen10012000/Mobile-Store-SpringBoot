package com.example.mobilewebspringboot.controller;

import java.util.Optional;

import com.example.mobilewebspringboot.entity.User;
import com.example.mobilewebspringboot.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }

    @PostMapping(value="/loginCheck")
    public String loginCheck(@RequestParam("username") String username, @RequestParam("password") String password) {
        //TODO: process POST request
        User user;
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            user = userOpt.get();
            boolean loginSuccess = user.login(username, password);
            if (loginSuccess) {
                return "productAdd.html";
            }
        }  
        return "login.html";
    }
    
}
