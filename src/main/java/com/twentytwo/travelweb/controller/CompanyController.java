package com.twentytwo.travelweb.controller;

import com.twentytwo.travelweb.entity.Company;
import com.twentytwo.travelweb.entity.OrderInfo;
import com.twentytwo.travelweb.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("index")
    public String indexPage(){
        return "background/com_index";
    }

    @GetMapping("updateinfo")
    public String updateInfo(Model model){
        Company company = companyService.getCompanyById("2");
        model.addAttribute("company",company);
        return "background/com_info";
    }

    @PostMapping("updateinfo")
    public String updateInfo(Company company){
        companyService.updateCompanyById(company);
        return "redirect:/company/updateinfo";
    }

    @GetMapping("orderlist")
    public String getOrderList(Model model){

        return "background/com_order";
    }

}
