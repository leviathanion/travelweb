package com.twentytwo.travelweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twentytwo.travelweb.entity.Product;
import com.twentytwo.travelweb.entity.ProductInfo;
import com.twentytwo.travelweb.entity.User;
import com.twentytwo.travelweb.service.ProductService;
import com.twentytwo.travelweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/detail")
    public String addUser(){
        return "foreground/product_detail";
    }

    @GetMapping("findOneRoute")
    public void findOneRoute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String product_id = request.getParameter("product_id");
        ProductInfo oneProductInfo = productService.findOneProductInfo(Integer.parseInt(product_id));

        myWriteValue(response,oneProductInfo);

    }

    @GetMapping("hasUser")
    public void hasUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String user_id;
        if(request.getSession().getAttribute("user") == null){
            user_id = null;
        }
        else {
            user_id = request.getSession().getAttribute("user").toString();
        }
        myWriteValue(response,user_id);
    }

    /*
     * 将商品信息等添加至订单
     * */
    @GetMapping("addIntoOrder")
    public void addIntoOrder(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String order_product=request.getParameter("order_product");
        String order_user=request.getSession().getAttribute("user").toString();
        String product_price = request.getParameter("product_price");
        String order_population = request.getParameter("order_population");
        double order_price = Double.parseDouble(product_price) * Integer.parseInt(order_population);
        productService.addIntoOrder(order_user,Integer.parseInt(order_product),Integer.parseInt(order_population),order_price);
    }

    /*
     * 获取服务器名字以及端口通用方法
     * */
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
