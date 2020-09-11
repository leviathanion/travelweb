package com.twentytwo.travelweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 卓永康
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("index")
    public String indexPage(){
        return "background/pro_index";
    }

    @GetMapping("userlist")
    public String getUserList(){
        return "background/pro_userlist";
    }

    @GetMapping("adduser")
    public String addUser(){
        return "background/pro_user_add";
    }

    @GetMapping("companylist")
    public String getCompantList(){
        return "background/pro_companylist";
    }

    @GetMapping("addcompany")
    public String addCompany(){
        return "background/pro_company_add";
    }

    @GetMapping("orderlist")
    public String getOrderList(){
        return "background/pro_orderlist";
    }

    @GetMapping("privilegelist")
    public String getPrivilegeList(){
        return "background/pro_privilege";
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
