package com.twentytwo.travelweb.controller;


import com.twentytwo.travelweb.entity.Admin;
import com.twentytwo.travelweb.entity.Company;
import com.twentytwo.travelweb.entity.User;
import com.twentytwo.travelweb.service.AdminService;
import com.twentytwo.travelweb.service.CompanyService;
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

    @Autowired
    CompanyService companyService;

    @Autowired
    AdminService adminService;


    @PostMapping("/adduser")
    public String addUser(User user){
        userService.addUser(user);
        return "foreground/register_success";
    }

    @PostMapping("/addcom")
    public String addCom(Company company){
        companyService.addCompany(company);
        return "foreground/register_success1";
    }

    @GetMapping("adduser")
    public String addUser(){
        return "foreground/register";
    }

    @GetMapping("addcom")
    public String addCom()  { return "foreground/register1";}

    @GetMapping("/login")
    //客户登陆
    public String logIn(){
        return "foreground/login";
    }

    @GetMapping("/login1")
    //商家登陆
    public String logIn1() {return "foreground/login1";}

    @GetMapping("/login2")
    //管理员登陆
    public String logIn2() {return "foreground/login2";}

    @ResponseBody
    @PostMapping("checkUserId")
    public boolean checkUserId(String user_id){
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
    @PostMapping("checkCompanyId")
    public boolean checkCompanyId(String com_id){
        Company company=companyService.getCompanyById(com_id);
        //System.out.println("收到");
        if(company==null){
            return true;
        }
        else{
            return false;
        }
    }

    @ResponseBody
    @PostMapping("checkUserPassword")
    public int checkUserPassword(String user_id,String user_pwd){
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

    @ResponseBody
    @PostMapping("checkCompanyPassword")
    public int checkCompanyPassword(String com_id,String com_pwd){
        Company company=companyService.getCompanyById(com_id);
        if (company==null){
            return 3;
            //没有注册
        }else if(company.getCom_pwd().equals(com_pwd)){
            return 1;
            //密码正确
        }else{
            return 2;
            //密码错误
        }
    }

    @ResponseBody
    @PostMapping("checkAdminPassword")
    public int checkAdminPassword(String admin_id,String admin_pwd){
        Admin admin=adminService.getAdminById(admin_id);
        if (admin==null){
            return 3;
            //没有注册
        }else if(admin.getAdmin_pwd().equals(admin_pwd)){
            return 1;
            //密码正确
        }else{
            return 2;
            //密码错误
        }
    }



}
