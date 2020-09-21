package com.twentytwo.travelweb.mapper;

import com.twentytwo.travelweb.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from product_info where product_active is true")
    List<Product> getAllProducts();

    @Select("select product_info.*,com_info.com_name from product_info,com_info where product_info.product_com = com_info.com_id")
    List<ProductInfo> getAllProductInfo();

    @Delete("delete from product_info where product_id = #{product_id}")
    Integer deleteProduct(Integer product_id);

    @Update("update product_info set product_name=#{product_name},product_route=#{product_route},product_starttime=#{product_starttime},product_endtime=#{product_endtime},product_img_url=#{product_img_url},product_introduce=#{product_introduce},product_price=#{product_price},product_active=#{product_active},category_id=#{category_id} where product_id=#{product_id}")
    Integer updateProduct(Product product);

    @Select("select * from product_info where product_id = #{product_id}")
    Product getProductById(Integer product_id);

    @Select("select * from product_info Order By product_click_count desc LIMIT 0,10")
    List<Product> getProductClickSum();

    @Select("select com_name,SUM(product_click_count) com_click_sum from product_info,com_info where product_com=com_id GROUP BY product_info.product_com ORDER BY com_click_sum DESC limit 0,10")
    List<ProductCom> getComClickSum();

    @Select("select product_info.* from product_info where product_com=#{com_id} ORDER BY product_click_count DESC LIMIT 0,10\n")
    List<Product> getProductClickByComId(String com_id);

    @Select("select product_info.*,com_info.com_name from product_info,com_info where product_info.product_com = com_info.com_id and com_info.com_id = #{com_id}")
    List<ProductInfo> getProductInfoByComId(String com_id);

    @Options(useGeneratedKeys = true,keyProperty = "product_id",keyColumn = "product_id")
    @Insert("insert into product_info (product_com,product_name,product_route,product_starttime,product_endtime,product_price,product_img_url,product_introduce,product_create_time,category_id) values (#{product_com},#{product_name},#{product_route},#{product_starttime},#{product_endtime},#{product_price},#{product_img_url},#{product_introduce},sysdate(),#{category_id})")
    Integer addPorduct(Product product);

    @Select("select product_info.*,com_info.com_name from product_info,com_info where product_info.product_com = com_info.com_id and product_id = #{product_id}")
    ProductInfo findOneProductInfoById(Integer product_id);

    @Select("select * from product_img where product_id=#{product_id}")
    List<ProductImg> findProductImg(Integer product_id);

    @Update("update product_info set product_active = 1 where product_id = #{product_id}")
    Integer checkProduct(Integer product_id);

    /*
     * 根据sid将产品添加至订单
     * */
    @Options(useGeneratedKeys = true,keyProperty = "order_id",keyColumn = "order_id")
    @Insert("insert into order_info ( order_user, order_product, order_population, order_price, order_ispaid, order_active, order_create_date) values (#{order_user}, #{order_product}, #{order_population}, #{order_price}, 0, 1, sysdate())")
    Integer addIntoOrder(Order order);


    @Select("select count(*) from product_info where product_active is true")
    int findTotalCount1();

    @Select("select count(*) from product_info where product_active is true and category_id=#{category_id}")
    int findTotalCount(int category_id);

    @Select("select count(*) from product_info where product_active is true and product_name like #{category_name}")
    int findTotalCount3(String category_name);

    @Select("select count(*) from product_info where product_active is true and category_id=#{category_id} and product_name like #{category_name}")
    int findTotalCount4(@Param("category_id") int category_id, @Param("category_name") String category_name);


    @Select("select * from product_info where product_active is true limit #{start},#{pageSize}")
    List<Product> findByPage1(@Param("start") int start, @Param("pageSize") int pageSize);

    @Select("select * from product_info where product_active is true and category_id=#{category_id} limit #{start},#{pageSize}")
    List<Product> findByPage(@Param("category_id") int category_id,@Param("start") int start,@Param("pageSize") int pageSize);

    @Select("select * from product_info where product_active is true and product_name like #{category_name}  limit #{start},#{pageSize}")
    List<Product> findByPage3(@Param("start") int start,@Param("pageSize") int pageSize,@Param("category_name") String category_name);

    @Select("select * from product_info where product_active is true and category_id=#{category_id} and product_name like #{category_name}  limit #{start},#{pageSize}")
    List<Product> findByPage4(@Param("category_id") int category_id,@Param("start") int start,@Param("pageSize") int pageSize,@Param("category_name") String category_name);

    /*
     * 根据rid查询图片信息
     * */
    @Select("select * from product_img where product_id=#{product_id}")
    List<ProductImg> findRouteImg(int product_id);


    /*
     * 根据sid查询商家信息
     * */
    @Select("select * from com_info where com_id=#{com_id}")
    Company findSeller(int sid);


    @Select("select * from product_info where product_active is true order by product_click_count desc limit 8 ")
    List<Product> findClickEightRank();

    /*
     * 最新旅游，筛选出最新的4条
     * */
    @Select("SELECT * FROM `product_info` where product_active is true order by product_create_time desc limit 8 ")
    List<Product> findNewFour();

    @Select("Select * from news_info where news_status is true order by news_create_date desc limit 6 ")
    List<NewsInfo> findNews();


    @Select("SELECT * FROM product_info AS t1 JOIN (SELECT ROUND(RAND() *  (\n" +
            "( SELECT MAX( product_id ) FROM product_info WHERE product_active IS TRUE)-( SELECT Min( product_id ) FROM product_info WHERE product_active IS TRUE))+ ( SELECT MIN( product_id ) FROM product_info WHERE product_active IS TRUE)) AS product_id) AS t2\n" +
            "LIMIT 8")
    List<Product> findRandEightRoute();

    @Update("update product_info set product_click_count = product_click_count + 1 where product_id = #{product_id}")
    Integer addClickCount(int product_id);

    @Insert("insert into product_img (product_id,big_img,small_img) values (#{product_id},#{big_img},#{small_img})")
    Integer addProductImg(@Param("product_id") int product_id,@Param("big_img") String big_img,@Param("small_img") String small_img);

    @Update("update product_img set big_img=#{big_img},small_img=#{small_img} where img_id=#{img_id}")
    Integer updateProductImg(@Param("img_id") int img_id,@Param("big_img") String big_img,@Param("small_img") String small_img);
}
