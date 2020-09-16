package com.twentytwo.travelweb.service;

import com.twentytwo.travelweb.entity.Product;
import com.twentytwo.travelweb.entity.ProductCom;
import com.twentytwo.travelweb.entity.ProductInfo;
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
    Integer addIntoOrder(String order_user,int order_product,int order_population,double order_price);
}
