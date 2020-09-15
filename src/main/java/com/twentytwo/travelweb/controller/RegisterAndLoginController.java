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
public class RegisterAndLoginController {

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

    @ResponseBody
    @PostMapping("checkPassword")
    public int checkPassword(String user_id,String user_pwd){
        User user=userService.getUserById(user_id);
        if (user==null){
            return 3;
            //没有注册
        }else if(user.getUser_pwd().equals(user_pwd)){
            return 1;
            //密码正确
        }else{
            return 2;
            //密码错误
        }
    }

}
