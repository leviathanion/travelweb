package com.twentytwo.travelweb.controller;

import com.twentytwo.travelweb.entity.*;
import com.twentytwo.travelweb.mapper.NewsMapper;
import com.twentytwo.travelweb.service.CompanyService;
import com.twentytwo.travelweb.service.NewsService;
import com.twentytwo.travelweb.service.OrderService;
import com.twentytwo.travelweb.service.ProductService;
import com.twentytwo.travelweb.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

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
        return "background/com_index";
    }

    @RequestMapping("/getProductClickCount")
    @ResponseBody
    public List<Product> getProductClickCount(HttpServletRequest request){
        List<Product> pro_click_count=productService.getProductClickByComId(request.getSession().getAttribute("com").toString());

        return pro_click_count;
    }

    @RequestMapping("/getOrderCount")
    @ResponseBody
    public List<Sales> getOrderCountByCom(HttpServletRequest request){
        List<Sales> order_count=orderService.getOrderSumByComId(request.getSession().getAttribute("com").toString());

        return order_count;
    }

    @RequestMapping("/getOrderPriceSum")
    @ResponseBody
    public List<OrderSumPrice> getOrderPriceSumByCom(HttpServletRequest request){
        List<OrderSumPrice> order_count=orderService.getOrderPriceSumByComId(request.getSession().getAttribute("com").toString());

        return order_count;
    }

    @RequestMapping("/getOrderSumBySexCom")
    @ResponseBody
    public List<UserOrderBySex> getOrderSumBySexCom(HttpServletRequest request){
        List<UserOrderBySex> sales=orderService.getUserOrderBySexCom(request.getSession().getAttribute("com").toString());

        return sales;
    }

    @RequestMapping("/getOrderSumByJobCom")
    @ResponseBody
    public List<UserSumByJob> getOrderSumByJobCom(HttpServletRequest request){
        List<UserSumByJob> sales=orderService.getOrderSumByJobCom(request.getSession().getAttribute("com").toString());

        return sales;
    }

    @RequestMapping("/getComProductCount")
    @ResponseBody
    public List<OrderByMonth> getComProductCount(@RequestParam(value = "product_id",defaultValue = "0") int product_id, HttpServletRequest request){
        List<OrderByMonth> product_count=new ArrayList<>();
        if(product_id==0) {
            product_count = orderService.getSumByMonthCom(request.getSession().getAttribute("com").toString());
        }else{
            product_count=orderService.getSumByMonthByPro(product_id);
        }
        return product_count;
    }

    @RequestMapping("/getComPriceSum")
    @ResponseBody
    public List<OrderPriceByMonth> getComPriceSum(@RequestParam(value = "product_id",defaultValue = "0") int product_id, HttpServletRequest request){
        List<OrderPriceByMonth> product_count=new ArrayList<>();
        if(product_id==0) {
            product_count = orderService.getOrderSumPriceByComMonth(request.getSession().getAttribute("com").toString());
        }else{
            product_count=orderService.getPriceSumByMonthPro(product_id);
        }
        return product_count;
    }

    @RequestMapping("/getComProductCountBySex")
    @ResponseBody
    public List<UserOrderBySex> getComProductCountBySex(@RequestParam(value = "product_id",defaultValue = "0") int product_id, HttpServletRequest request){
        List<UserOrderBySex> product_count=new ArrayList<>();
        if(product_id==0) {
            product_count = orderService.getUserOrderBySexCom(request.getSession().getAttribute("com").toString());
        }else{
            product_count=orderService.getOrderBySexPro(product_id);
        }
        return product_count;
    }

    @RequestMapping("/getComProductCountByJob")
    @ResponseBody
    public List<UserSumByJob> getComProductCountByJob(@RequestParam(value = "product_id",defaultValue = "0") int product_id, HttpServletRequest request){
        List<UserSumByJob> product_count=new ArrayList<>();
        if(product_id==0) {
            product_count = orderService.getOrderSumByJobCom(request.getSession().getAttribute("com").toString());
        }else{
            product_count=orderService.getSumByUserJobPro(product_id);
        }
        return product_count;
    }

    @RequestMapping("/comproductcount")
    public String getProductCount(
            @RequestParam(value = "product_id",defaultValue = "0") int product_id,
            Model model, HttpServletRequest request){

        List<ProductInfo> product=productService.getProductInfoByComId(request.getSession().getAttribute("com").toString());
        model.addAttribute("product",product);
        model.addAttribute("product_id",product_id);

        return "background/com_pro_sales_search";
    }

    @GetMapping("productSalesCount")
    public String getOrderCount(){
        return "background/com_pro_sales_count";
    }

    @GetMapping("productClickCount")
    public String getProductClick(){

        return "background/com_pro_click_count";

    }

    @GetMapping("updateinfo")
    public String updateInfo(Model model, HttpServletRequest request){
        Company company = companyService.getCompanyById(request.getSession().getAttribute("com").toString());
        model.addAttribute("company",company);
        return "background/com_info";
    }

    @PostMapping("updateinfo")
    public String updateInfo(Company company){
        companyService.updateCompanyById(company);
        return "redirect:/company/updateinfo";
    }

    @GetMapping("orderlist")
    public String getOrderList(Model model, HttpServletRequest request){
        List<OrderInfo> orderInfoList = orderService.getOrderInfoByComId(request.getSession().getAttribute("com").toString());
        model.addAttribute("orders",orderInfoList);
        return "background/com_order";
    }

    @GetMapping("deleteorder/{order_id}")
    public String deleteOrder(@PathVariable("order_id") Integer order_id){

        orderService.deleteOrder(order_id);
        return "redirect:/company/orderlist";
    }

    @GetMapping("productlist")
    public String getProductList(Model model,HttpServletRequest request){
        List<ProductInfo> productInfos = productService.getProductInfoByComId(request.getSession().getAttribute("com").toString());
        model.addAttribute("products",productInfos);
        return "background/com_productlist";
    }

    @GetMapping("deleteproduct/{product_id}")
    public String deleteProduct(@PathVariable("product_id") Integer product_id){
        productService.deleteProduct(product_id);
        return "redirect:/company/productlist";
    }

    @GetMapping("/updateproduct/{product_id}")
    public String updateProduct(@PathVariable("product_id") Integer product_id,Model model){
        List<ProductImg> productImgList = productService.findRouteImg(product_id);
        int i = 1;
        for(ProductImg productImg:productImgList ){
            model.addAttribute("image"+i,productImg);
            i++;
        }

        Product product = productService.getProductById(product_id);
        model.addAttribute("product",product);

        return "background/com_product_update";
    }

    @PostMapping("/updateproduct")
    public String updateProduct(Product product,@RequestParam("filepic1") MultipartFile file1,@RequestParam("filepic2") MultipartFile file2,@RequestParam("filepic3") MultipartFile file3,@RequestParam("filepic4") MultipartFile file4){
        String fileName1 = file1.getOriginalFilename();
        String fileName2 = file2.getOriginalFilename();
        String fileName3 = file3.getOriginalFilename();
        String fileName4 = file4.getOriginalFilename();
        List<ProductImg> productImgList = productService.findRouteImg(product.getProduct_id());
        if(fileName1.contains(".")){
            String filePath = FileUtil.getUploadFilePath();
            fileName1 = System.currentTimeMillis()+fileName1;

            try {
                FileUtil.uploadFile(file1.getBytes(),filePath,fileName1);
                fileName1 = "/images/"+fileName1;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            fileName1 = productImgList.get(0).getBig_img();
        }


        if(fileName2.contains(".")){
            String filePath = FileUtil.getUploadFilePath();
            fileName2 = System.currentTimeMillis()+fileName2;

            try {
                FileUtil.uploadFile(file2.getBytes(),filePath,fileName2);
                fileName2 = "/images/"+fileName2;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            fileName2 = productImgList.get(1).getBig_img();
        }

        if(fileName3.contains(".")){
            String filePath = FileUtil.getUploadFilePath();
            fileName3 = System.currentTimeMillis()+fileName3;

            try {
                FileUtil.uploadFile(file3.getBytes(),filePath,fileName3);
                fileName3 = "/images/"+fileName3;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            fileName3 = productImgList.get(2).getBig_img();
        }

        if(fileName4.contains(".")){
            String filePath = FileUtil.getUploadFilePath();
            fileName4 = System.currentTimeMillis()+fileName4;

            try {
                FileUtil.uploadFile(file4.getBytes(),filePath,fileName4);
                fileName4 = "/images/"+fileName4;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            fileName4 = productImgList.get(3).getBig_img();
        }

        product.setProduct_img_url(fileName1);
        productService.updateProduct(product);

        productService.updateProductImg(productImgList.get(0).getImg_id(),fileName1,fileName1);
        productService.updateProductImg(productImgList.get(1).getImg_id(),fileName2,fileName2);
        productService.updateProductImg(productImgList.get(2).getImg_id(),fileName3,fileName3);
        productService.updateProductImg(productImgList.get(3).getImg_id(),fileName4,fileName4);

        return "redirect:/company/productlist";
    }

    @GetMapping("newslist")
    public String getNewsList(Model model,HttpServletRequest request){
        List<NewsInfo> newsInfoList = newsService.getNewsInfoByComId(request.getSession().getAttribute("com").toString());
        model.addAttribute("news",newsInfoList);
        return "background/com_newslist";
    }

    @GetMapping("deletenews/{news_id}")
    public String deleteNews(@PathVariable("news_id") Integer news_id){
        newsService.deleteNews(news_id);
        return "redirect:/company/newslist";
    }

    @GetMapping("updatenews/{news_id}")
    public String updateNews(@PathVariable("news_id") Integer news_id,Model model,HttpServletRequest request){
        News news = newsService.getNewsById(news_id);
        model.addAttribute("news",news);
        List<ProductInfo> productInfos = productService.getProductInfoByComId(request.getSession().getAttribute("com").toString());
        model.addAttribute("products",productInfos);
        return "background/com_news_update";
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
        return "redirect:/company/newslist";
    }

    @GetMapping("newsadd")
    public String addNews(Model model,HttpServletRequest request){
        List<ProductInfo> productInfos = productService.getProductInfoByComId(request.getSession().getAttribute("com").toString());
        model.addAttribute("products",productInfos);
        return "background/com_news_release";
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
        return "redirect:/company/newslist";
    }

    @GetMapping("addproduct")
    public String addProduct(){

        return "background/com_product_add";
    }

    @PostMapping("addproduct")
    public String addProduct(Product product,@RequestParam("filepic1") MultipartFile file1,@RequestParam("filepic2") MultipartFile file2,@RequestParam("filepic3") MultipartFile file3,@RequestParam("filepic4") MultipartFile file4,HttpServletRequest request){
        String fileName1 = file1.getOriginalFilename();
        String fileName2 = file2.getOriginalFilename();
        String fileName3 = file3.getOriginalFilename();
        String fileName4 = file4.getOriginalFilename();
        String filePath = FileUtil.getUploadFilePath();
        String temp = null;

        fileName1 = System.currentTimeMillis()+fileName1;
        fileName2 = System.currentTimeMillis()+fileName2;
        fileName3 = System.currentTimeMillis()+fileName3;
        fileName4 = System.currentTimeMillis()+fileName4;


        try {
            FileUtil.uploadFile(file1.getBytes(),filePath,fileName1);
            FileUtil.uploadFile(file2.getBytes(),filePath,fileName2);
            FileUtil.uploadFile(file3.getBytes(),filePath,fileName3);
            FileUtil.uploadFile(file4.getBytes(),filePath,fileName4);
        } catch (Exception e) {
            e.printStackTrace();
        }



        fileName1 = "/images/"+fileName1;
        fileName2 = "/images/"+fileName2;
        fileName3 = "/images/"+fileName3;
        fileName4 = "/images/"+fileName4;

        if(fileName1.contains(".")){
            temp = fileName1;
        }else{
            if(fileName2.contains(".")){
                temp = fileName2;
            }else{
                if(fileName3.contains(".")){
                    temp = fileName3;
                }else{
                    if(fileName4.contains(".")){
                        temp = fileName4;
                    }else{
                        temp = "";
                    }
                }
            }
        }

        product.setProduct_img_url(temp);
        product.setProduct_com(request.getSession().getAttribute("com").toString());

        productService.addPorduct(product);

        productService.addProductImg(product.getProduct_id(),fileName1,fileName1);
        productService.addProductImg(product.getProduct_id(),fileName2,fileName2);
        productService.addProductImg(product.getProduct_id(),fileName3,fileName3);
        productService.addProductImg(product.getProduct_id(),fileName4,fileName4);
        return "redirect:/company/productlist";

    }

}
