package com.twentytwo.travelweb.controller;


import com.twentytwo.travelweb.entity.User;
import com.twentytwo.travelweb.service.UserService;
import com.twentytwo.travelweb.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;


    @PostMapping("/adduser")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/admin/userlist";
    }

    @GetMapping("adduser")
    public String addUser(){
        return "foreground/register";
    }

}
