package com.twentytwo.travelweb.controller;


import com.twentytwo.travelweb.entity.User;
import com.twentytwo.travelweb.service.UserService;
import com.twentytwo.travelweb.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;


    @PostMapping("/adduser")
    public String addUser(User user){
        userService.addUser(user);
        return "foreground/register_success";
    }

    @GetMapping("adduser")
    public String addUser(){
        return "foreground/register";
    }

    @GetMapping("/login")
    public String logIn(){
        return "foreground/login";
    }

    @ResponseBody
    @PostMapping("checkId")
    public boolean checkIdResult(String user_id){
        User user=userService.getUserById(user_id);
        //System.out.println("收到");
        if(user==null){
            return true;
        }
        else{
            return false;
        }

    }

}
