package com.twentytwo.travelweb.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public int checkUserPassword(String user_id, String user_pwd, HttpServletRequest request){
        User user=userService.getUserById(user_id);
        if (user==null){
            return 3;
            //没有注册
        }else if(user.getUser_pwd().equals(user_pwd)){
            request.getSession().setAttribute("user",user.getUser_id());
            request.getSession().setAttribute("type","user");
            //request.getSession().getAttribute("type");
            //获得user类型
            //request.getSession().getAttribute("user");
            //获得user_id
            return 1;
            //密码正确
        }else{
            return 2;
            //密码错误
        }
    }

    @ResponseBody
    @PostMapping("checkCompanyPassword")
    public int checkCompanyPassword(String com_id,String com_pwd,HttpServletRequest request){
        Company company=companyService.getCompanyById(com_id);
        if (company==null){
            return 3;
            //没有注册
        }else if(company.getCom_pwd().equals(com_pwd)){
            request.getSession().setAttribute("user",company.getCom_id());
            request.getSession().setAttribute("type","company");
            return 1;
            //密码正确
        }else{
            return 2;
            //密码错误
        }
    }

    @ResponseBody
    @PostMapping("checkAdminPassword")
    public int checkAdminPassword(String admin_id,String admin_pwd,HttpServletRequest request){
        Admin admin=adminService.getAdminById(admin_id);
        if (admin==null){
            return 3;
            //没有注册
        }else if(admin.getAdmin_pwd().equals(admin_pwd)){
            request.getSession().setAttribute("user",admin.getAdmin_id());
            request.getSession().setAttribute("type","admin");
            return 1;
            //密码正确
        }else{
            return 2;
            //密码错误
        }
    }

    @GetMapping("getServerName")
    public void getServerName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //http://localhost:8080/travel_war_exploded
        String serverName = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        myWriteValue(response, serverName);
    }

    private void myWriteValue(HttpServletResponse response, Object object) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),object);

    }



}
