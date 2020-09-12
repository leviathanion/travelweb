package com.twentytwo.travelweb.mapper;

import com.twentytwo.travelweb.entity.Product;
import com.twentytwo.travelweb.entity.ProductInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from product_info")
    List<Product> getAllProducts();

    @Select("select product_info.*,com_info.com_name from product_info,com_info where product_info.product_com = com_info.com_id")
    List<ProductInfo> getAllProductInfo();

    @Delete("delete from product_info where product_id = #{product_id}")
    Integer deleteProduct(Integer product_id);

    @Update("update product_info set product_name=#{product_name},product_route=#{product_route},product_starttime=#{product_starttime},product_endtime=#{product_endtime},product_img_url=#{product_img_url},product_introduce=#{product_introduce} where product_id=#{product_id}")
    Integer updateProduct(Product product);

    @Select("select * from product_info where product_id = #{product_id}")
    Product getProductById(Integer product_id);

}
