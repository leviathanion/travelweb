package com.twentytwo.travelweb.controller;

import com.twentytwo.travelweb.entity.*;
import com.twentytwo.travelweb.service.*;
import com.twentytwo.travelweb.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import java.util.ArrayList;
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

    @Autowired
    ProductService productService;

    @Autowired
    NewsService newsService;

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
    public String deleteUser(@PathVariable("user_id") String user_id){
        userService.deleteUser(user_id);
        return "redirect:/admin/userlist";
    }

    @GetMapping("/updateuser/{user_id}")
    public String updateUser(@PathVariable("user_id") String user_id,Model model){
        User user = userService.getUserById(user_id);
        model.addAttribute("user",user);
        return "background/pro_user_update";
    }

    @PostMapping("/updateuser")
    public String updateUser(User user,@RequestParam("filepic") MultipartFile file){
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
    public String deleteCompany(@PathVariable("com_id") String com_id){
        companyService.deleteCompany(com_id);
        return "redirect:/admin/companylist";
    }

    @GetMapping("/updatecompany/{com_id}")
    public String updateCompany(@PathVariable("com_id") String com_id,Model model){
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
    public String updateUserPrivilege(@RequestParam(value = "user_id",defaultValue = "1") String user_id,
                                      @RequestParam(value = "privilege",defaultValue = "1") Integer privilege){

        userService.updateUserPrivilege(user_id,privilege);

        return "redirect:/admin/privilegelist";
    }

    @RequestMapping("/updatecomprivilege")
    public String updateCompanyPrivilege(@RequestParam(value = "com_id",defaultValue = "1") String com_id,
                                         @RequestParam(value = "privilege",defaultValue = "1") Integer privilege){
        companyService.updateCompanyPirvilege(com_id,privilege);

        return "redirect:/admin/privilegelist";
    }

    @RequestMapping("/getProductCount")
    @ResponseBody
    public List<OrderByMonth> getProductCount(@RequestParam(value = "product_id",defaultValue = "0") int product_id){
        List<OrderByMonth> product_count=new ArrayList<>();
        if(product_id==0) {
            product_count = orderService.getSumByMonth();
        }else{
            product_count=orderService.getSumByMonthByPro(product_id);
        }
        return product_count;
    }

    @RequestMapping("/getProductCountBySex")
    @ResponseBody
    public List<UserOrderBySex> getProductCountBySex(@RequestParam(value = "product_id",defaultValue = "0") int product_id){
        List<UserOrderBySex> product_count=new ArrayList<>();
        if(product_id==0) {
            product_count = orderService.getOrderBySex();
        }else{
            product_count=orderService.getOrderBySexPro(product_id);
        }
        return product_count;
    }

    @RequestMapping("/getProductCountByJob")
    @ResponseBody
    public List<UserSumByJob> getProductCountByJob(@RequestParam(value = "product_id",defaultValue = "0") int product_id){
        List<UserSumByJob> product_count=new ArrayList<>();
        if(product_id==0) {
            product_count = orderService.getSumByUserJob();
        }else{
            product_count=orderService.getSumByUserJobPro(product_id);
        }
        return product_count;
    }

    @RequestMapping("/productcount")
    public String getProductCount(
            @RequestParam(value = "product_id",defaultValue = "0") int product_id,
            Model model){


        List<Company> company=companyService.getAllCompanies();
        List<Product> product=productService.getAllProducts();
        model.addAttribute("company",company);
        model.addAttribute("product",product);
        model.addAttribute("product_id",product_id);

        return "background/pro_sales_search";
    }

    @RequestMapping("/getClickSum")
    @ResponseBody
    public List<Product> getClickSum(){
        List<Product> click_sum=new ArrayList<>();
        click_sum = productService.getProductClickSum();

        return click_sum;
    }

    @RequestMapping("/getComClickSum")
    @ResponseBody
    public List<ProductCom> getComClickSum(){
        List<ProductCom> com_click_sum=new ArrayList<>();
        com_click_sum = productService.getComClickSum();

        return com_click_sum;
    }

    @GetMapping("clickcount")
    public String getClickCount(){
        return "background/pro_click_count";
    }



    @RequestMapping("/getProSum")
    @ResponseBody
    public List<Sales> getProSums(){
        List<Sales> sales=new ArrayList<>();
        sales=orderService.getOrderNums();

        return sales;
    }

    @RequestMapping("/getMaleUserSum")
    @ResponseBody
    public List<Sales> getMaleUserSums(){
        List<Sales> sales=new ArrayList<>();
        sales=orderService.getMaleUserOrders();

        return sales;
    }

    @RequestMapping("/getFeMaleUserSum")
    @ResponseBody
    public List<Sales> getFeMaleUserSums(){
        List<Sales> sales=new ArrayList<>();
        sales=orderService.getFeMaleUserOrders();

        return sales;
    }

    @RequestMapping("/getOrderSumByUserJob1")
    @ResponseBody
    public List<Sales> getOrderSumByJob1(){
        List<Sales> sales=new ArrayList<>();
        sales = orderService.getOrderSumbyUserJob1();

        return sales;
    }

    @RequestMapping("/getOrderSumByUserJob2")
    @ResponseBody
    public List<Sales> getOrderSumByJob2(){
        List<Sales> sales=new ArrayList<>();
        sales = orderService.getOrderSumbyUserJob2();

        return sales;
    }

    @RequestMapping("/getOrderSumByUserJob3")
    @ResponseBody
    public List<Sales> getOrderSumByJob3(){
        List<Sales> sales=new ArrayList<>();
        sales = orderService.getOrderSumbyUserJob3();

        return sales;
    }

    @RequestMapping("/getOrderSumByUserJob4")
    @ResponseBody
    public List<Sales> getOrderSumByJob4(){
        List<Sales> sales=new ArrayList<>();
        sales = orderService.getOrderSumbyUserJob4();

        return sales;
    }

    @RequestMapping("/getOrderSumByUserSex")
    @ResponseBody
    public List<UserOrderBySex> getOrderSumByUserSex(){
        List<UserOrderBySex> sales=new ArrayList<>();
        sales = orderService.getOrderBySex();

        return sales;
    }

    @RequestMapping("/getSumByUserJob")
    @ResponseBody
    public List<UserSumByJob> getSumByUserJob(){
        List<UserSumByJob> sales=new ArrayList<>();
        sales = orderService.getSumByUserJob();

        return sales;
    }

    @GetMapping("/salescount")
    public String getSalesCount(){
        return "background/pro_sales_count";
    }


    @GetMapping("productlist")
    public String getProductList(Model model){
        List<ProductInfo> productList = productService.getAllProductInfo();
        model.addAttribute("products",productList);
        return "background/pro_productlist";
    }

    @GetMapping("deleteproduct/{product_id}")
    public String deleteProduct(@PathVariable("product_id") Integer product_id){
        productService.deleteProduct(product_id);
        return "redirect:/admin/productlist";
    }

    @GetMapping("/updateproduct/{product_id}")
    public String updateProduct(@PathVariable("product_id") Integer product_id,Model model){
        Product product = productService.getProductById(product_id);
        model.addAttribute("product",product);

        return "background/pro_product_update";
    }

    @PostMapping("/updateproduct")
    public String updateProduct(Product product,@RequestParam("filepic") MultipartFile file){
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
            Product product1 = productService.getProductById(product.getProduct_id());
            fileName = product1.getProduct_img_url();
        }
        product.setProduct_img_url(fileName);
        productService.updateProduct(product);
        return "redirect:/admin/productlist";

    }

    @GetMapping("newslist")
    public String getNewsList(Model model){
        List<NewsInfo> newsInfoList = newsService.getAllNewsInfo();
        model.addAttribute("news",newsInfoList);
        return "background/pro_news";
    }

    @GetMapping("newsadd")
    public String addNews(Model model){
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products",productList);
        return "background/pro_news_release";
    }

    @PostMapping("newsadd")
    public String addNews(News news,@RequestParam("filepic") MultipartFile file){
        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUploadFilePath();
        fileName = System.currentTimeMillis()+fileName;

        try {
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        news.setNews_img_url(fileName);
        newsService.releaseNews(news);
        return "redirect:/admin/newslist";
    }

    @GetMapping("deletenews/{news_id}")
    public String deleteNews(@PathVariable("news_id") Integer news_id){
        newsService.deleteNews(news_id);
        return "redirect:/admin/newslist";
    }

    @GetMapping("updatenews/{news_id}")
    public String updateNews(@PathVariable("news_id") Integer news_id,Model model){
        News news = newsService.getNewsById(news_id);
        model.addAttribute("news",news);
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products",productList);
        return "background/pro_news_update";
    }

    @PostMapping("updatenews")
    public String updateNews(News news,@RequestParam("filepic") MultipartFile file){
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
            News news1 = newsService.getNewsById(news.getNews_id());
            fileName = news1.getNews_img_url();
        }
        news.setNews_img_url(fileName);
        newsService.updateNews(news);
        return "redirect:/admin/newslist";
    }

}
