package com.twentytwo.travelweb.controller;

import com.twentytwo.travelweb.entity.Company;
import com.twentytwo.travelweb.entity.Order;
import com.twentytwo.travelweb.entity.OrderInfo;
import com.twentytwo.travelweb.entity.User;
import com.twentytwo.travelweb.service.CompanyService;
import com.twentytwo.travelweb.service.OrderService;
import com.twentytwo.travelweb.service.UserService;
import com.twentytwo.travelweb.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 卓永康
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Autowired
    OrderService orderService;

    @GetMapping("index")
    public String indexPage(){
        return "background/pro_index";
    }

    @GetMapping("userlist")
    public String getUserList(Model model){
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users",userList);
        return "background/pro_userlist";
    }

    @GetMapping("adduser")
    public String addUser(){
        return "background/pro_user_add";
    }

    @PostMapping("/adduser")
    public String addUser(User user,@RequestParam("filepic") MultipartFile file){

        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUploadFilePath();
        fileName = System.currentTimeMillis()+fileName;

        try {
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        user.setUser_img_url(fileName);
        userService.addUser(user);

        return "redirect:/admin/userlist";
    }

    @GetMapping("/deleteuser/{user_id}")
    public String deleteUser(@PathVariable("user_id") Integer user_id){
        userService.deleteUser(user_id);
        return "redirect:/admin/userlist";
    }

    @GetMapping("/updateuser/{user_id}")
    public String updateUser(@PathVariable("user_id") Integer user_id,Model model){
        User user = userService.getUserById(user_id);
        model.addAttribute("user",user);
        return "background/pro_user_update";
    }

    @PostMapping("/updateuser")
    public String updateUser(User user,@RequestParam("filepic") MultipartFile file){
        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUploadFilePath();
        fileName = System.currentTimeMillis()+fileName;

        try {
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setUser_img_url(fileName);
        userService.updateUserById(user);
        return "redirect:/admin/userlist";
    }

    @GetMapping("companylist")
    public String getCompantList(Model model){
        List<Company> companyList = companyService.getAllCompanies();
        model.addAttribute("companies",companyList);
        return "background/pro_companylist";
    }

    @GetMapping("addcompany")
    public String addCompany(){
        return "background/pro_company_add";
    }

    @PostMapping("addcompany")
    public String addCompany(Company company){
        companyService.addCompany(company);

        return "redirect:/admin/companylist";
    }

    @GetMapping("/deletecompany/{com_id}")
    public String deleteCompany(@PathVariable("com_id") Integer com_id){
        companyService.deleteCompany(com_id);
        return "redirect:/admin/companylist";
    }

    @GetMapping("/updatecompany/{com_id}")
    public String updateCompany(@PathVariable("com_id") Integer com_id,Model model){
        Company company = companyService.getCompanyById(com_id);
        model.addAttribute("company",company);
        return "background/pro_company_update";
    }

    @PostMapping("/updatecompany")
    public String updateCompany(Company company){

        companyService.updateCompanyById(company);
        return "redirect:/admin/companylist";
    }

    @GetMapping("orderlist")
    public String getOrderList(Model model){
        List<OrderInfo> orderInfoList = orderService.getAllOrderInfo();
        model.addAttribute("orders",orderInfoList);
        return "background/pro_orderlist";
    }

    @GetMapping("deleteorder/{order_id}")
    public String deleteOrder(@PathVariable("order_id") Integer order_id){

        orderService.deleteOrder(order_id);
        return "redirect:/admin/orderlist";
    }

    @GetMapping("privilegelist")
    public String getPrivilegeList(Model model){
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users",userList);
        List<Company> companyList = companyService.getAllCompanies();
        model.addAttribute("companies",companyList);
        return "background/pro_privilege";
    }

    @RequestMapping("/updateuserprivilege")
    public String updateUserPrivilege(@RequestParam(value = "user_id",defaultValue = "1") Integer user_id,
                                      @RequestParam(value = "privilege",defaultValue = "1") Integer privilege){

        userService.updateUserPrivilege(user_id,privilege);

        return "redirect:/admin/privilegelist";
    }

    @RequestMapping("/updatecomprivilege")
    public String updateCompanyPrivilege(@RequestParam(value = "com_id",defaultValue = "1") Integer com_id,
                                         @RequestParam(value = "privilege",defaultValue = "1") Integer privilege){
        companyService.updateCompanyPirvilege(com_id,privilege);

        return "redirect:/admin/privilegelist";
    }

    @GetMapping("productcount")
    public String getProductCount(){
        return "background/pro_sales_search";
    }

    @GetMapping("clickcount")
    public String getClickCount(){
        return "background/pro_click_count";
    }

    @GetMapping("salescount")
    public String getSalesCount(){
        return "background/pro_sales_count";
    }

    @GetMapping("productlist")
    public String getProductList(){
        return "background/pro_productlist";
    }

    @GetMapping("newslist")
    public String getNewsList(){
        return "background/pro_news";
    }

    @GetMapping("newsadd")
    public String addNews(){
        return "background/pro_news_release";
    }

}
