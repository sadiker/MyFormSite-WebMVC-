package com.sadiker.MyFormSite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.sadiker.MyFormSite.models.User;
import com.sadiker.MyFormSite.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/createUser") 
    public String createUser(ModelMap map ) {
        User user = new User();
        map.addAttribute("user", user);
        return "/user/createUser" ;

    }
    @PostMapping("/saveUser") 
    public String saveUser(@ModelAttribute User user 
    ) {
        user.setRole("NORMAL");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/home" ;
    }

    @GetMapping("/showAllUser") 
    public String showAllUser(ModelMap map) {
        List<User> allUsers = userRepository.findAll();
        map.addAttribute("allUsers", allUsers);
        return "/user/showAllUser" ;
    }
    
}
