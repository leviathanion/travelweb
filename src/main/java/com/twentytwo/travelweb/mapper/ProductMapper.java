package com.twentytwo.travelweb.mapper;

import com.twentytwo.travelweb.entity.Product;
import com.twentytwo.travelweb.entity.ProductCom;
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

    @Update("update product_info set product_name=#{product_name},product_route=#{product_route},product_starttime=#{product_starttime},product_endtime=#{product_endtime},product_img_url=#{product_img_url},product_introduce=#{product_introduce},product_price=#{product_price} where product_id=#{product_id}")
    Integer updateProduct(Product product);

    @Select("select * from product_info where product_id = #{product_id}")
    Product getProductById(Integer product_id);

    @Select("select * from product_info Order By product_click_count desc LIMIT 0,10")
    List<Product> getProductClickSum();

    @Select("select com_name,SUM(product_click_count) com_click_sum from product_info,com_info where product_com=com_id GROUP BY product_info.product_com ORDER BY com_click_sum DESC limit 0,10")
    List<ProductCom> getComClickSum();

    @Select("select product_info.*,com_info.com_name from product_info,com_info where product_info.product_com = com_info.com_id and com_info.com_id = #{com_id}")
    List<ProductInfo> getProductInfoByComId(String com_id);

    @Insert("insert into product_info (product_com,product_name,product_route,product_starttime,product_endtime,product_price,product_img_url,product_introduce,product_create_time) values (#{product_com},#{product_name},#{product_route},#{product_starttime},#{product_endtime},#{product_price},#{product_img_url},#{product_introduce},sysdate())")
    Integer addPorduct(Product product);
}
