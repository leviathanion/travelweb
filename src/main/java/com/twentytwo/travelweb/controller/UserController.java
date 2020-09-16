package com.twentytwo.travelweb.controller;

import com.twentytwo.travelweb.entity.*;
import com.twentytwo.travelweb.service.NewsService;
import com.twentytwo.travelweb.service.OrderService;
import com.twentytwo.travelweb.service.UserService;
import com.twentytwo.travelweb.util.FileUtil;
import jdk.nashorn.internal.IntDeque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    NewsService newsService;

    @GetMapping("userinfo")
    public String getUserInfo(Model model){
        User user=userService.getUserById("123");
        model.addAttribute("user",user);
        return "foreground/user_info";
    }

    @GetMapping("/updateUserInfo")
    public String updateUserInfo(Model model){
        User user=userService.getUserById("123");
        model.addAttribute("user",user);
        return "foreground/user_update";
    }

    @PostMapping("/updateUserInfo")
    public String updateUserInfo(User user,@RequestParam("filepic") MultipartFile file){
        String fileName = file.getOriginalFilename();
        if(fileName.contains(".")){
            String filePath = FileUtil.getUploadFilePath();
            fileName = System.currentTimeMillis()+fileName;

            try {
                FileUtil.uploadFile(file.getBytes(),filePath,fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            User user1 = userService.getUserById(user.getUser_id());
            fileName = user1.getUser_img_url();
        }
        user.setUser_img_url(fileName);
        userService.updateUserById(user);
        return "redirect:/user/userinfo";
    }

    @GetMapping("showMyOrder")
    public String showMyOrder(Model model,String user_id){
        List<UserOrderInfo> orderInfoList=orderService.getOrderInfoByUserID("123");
        model.addAttribute("orderInfoList",orderInfoList);
        return "foreground/myorder";

    }

    @GetMapping("payMethod")
    public String payMethod(){
        return "foreground/pay_method";
    }

    @GetMapping("payCompleted")
    public String payCompleted(){
        return "foreground/pay_completed";
    }

    @GetMapping("/news")
    public String news(Model model){
        NewsInfo newsInfo=newsService.getNewsInfoByID(4);
        model.addAttribute("newsInfo",newsInfo);
        return "foreground/news";
    }


}
