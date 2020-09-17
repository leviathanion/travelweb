package com.twentytwo.travelweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twentytwo.travelweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping({"findAllCategory", "/product/findAllCategory","/register/findAllCategory","/user/news/findAllCategory","/user/findAllCategory","/user/payCompleted/findAllCategory"})
    public void FindAllCategory(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Map<String,String> categorys = categoryService.findAll();



        /*简化操作*/
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        String categorysStr = mapper.writeValueAsString(categorys);

        response.getWriter().write(categorysStr);
//        myWriteValue(categorys,response);
    }




    private void myWriteValue(Object object, HttpServletResponse response) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),object);
    }
}
