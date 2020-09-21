package com.twentytwo.travelweb.service;

import com.twentytwo.travelweb.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    List<ProductInfo> getAllProductInfo();
    Integer deleteProduct(Integer product_id);
    Integer updateProduct(Product product);
    Product getProductById(Integer product_id);
    List<Product> getProductClickSum();
    List<ProductCom> getComClickSum();
    List<ProductInfo> getProductInfoByComId(String com_id);
    Integer addPorduct(Product product);
    ProductInfo findOneProductInfo(Integer product_id);
    Integer addIntoOrder(Order order);
    PageBean<Product> pageQuery(int category_id, int currentPage, int pageSize, String name);
    List<Product> clickEightRank();
    Integer checkProduct(Integer product_id);
    List<Product> theNewFour();

    int findTotalRoute();

    List<Product> findRandEightRoute();

    List<NewsInfo> newsList();

    List<Product> getProductClickByComId(String com_id);
    Integer addClickCount(int product_id);
    Integer addProductImg(int product_id,String big_img,String small_img);
    List<ProductImg> findRouteImg(int product_id);
    Integer updateProductImg( int img_id, String big_img, String small_img);

}
