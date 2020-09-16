package com.twentytwo.travelweb.mapper;

import com.twentytwo.travelweb.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from order_info")
    List<Order> getAllOrders();

    @Select("select order_info.*,user_info.user_name,product_info.product_name,com_info.com_name from order_info,user_info,product_info,com_info where order_info.order_user=user_info.user_id and product_info.product_com=com_info.com_id and order_info.order_product=product_info.product_id")
    List<OrderInfo> getAllOrderInfo();

    @Delete("delete from order_info where order_id=#{order_id}")
    Integer deleteOrder(Integer order_id);

    @Select("SELECT product_info.product_name,SUM(order_info.order_population) product_sum FROM product_info,order_info WHERE product_info.product_id=order_info.order_product GROUP BY order_product Order By product_sum desc LIMIT 0,10")
    List<Sales> getOrderNums();

    @Select("SELECT product_info.product_name,SUM(order_info.order_population) product_sum FROM product_info,order_info,user_info WHERE product_info.product_id=order_info.order_product and order_info.order_user=user_info.user_id and user_sex=1 GROUP BY order_product Order By product_sum desc LIMIT 0,10\n")
    List<Sales> getMaleUserOrders();

    @Select("SELECT product_info.product_name,SUM(order_info.order_population) product_sum FROM product_info,order_info,user_info WHERE product_info.product_id=order_info.order_product and order_info.order_user=user_info.user_id and user_sex=0 GROUP BY order_product Order By product_sum desc LIMIT 0,10\n")
    List<Sales> getFeMaleUserOrders();

    @Select("SELECT product_info.product_name,SUM(order_info.order_population) product_sum FROM product_info,order_info,user_info WHERE product_info.product_id=order_info.order_product and order_info.order_user=user_info.user_id and user_job='学生' GROUP BY order_product Order By product_sum desc LIMIT 0,10\n")
    List<Sales> getOrderSumbyUserJob1();

    @Select("SELECT product_info.product_name,SUM(order_info.order_population) product_sum FROM product_info,order_info,user_info WHERE product_info.product_id=order_info.order_product and order_info.order_user=user_info.user_id and user_job='教师' GROUP BY order_product Order By product_sum desc LIMIT 0,10\n")
    List<Sales> getOrderSumbyUserJob2();

    @Select("SELECT product_info.product_name,SUM(order_info.order_population) product_sum FROM product_info,order_info,user_info WHERE product_info.product_id=order_info.order_product and order_info.order_user=user_info.user_id and user_job='医生' GROUP BY order_product Order By product_sum desc LIMIT 0,10\n")
    List<Sales> getOrderSumbyUserJob3();

    @Select("SELECT product_info.product_name,SUM(order_info.order_population) product_sum FROM product_info,order_info,user_info WHERE product_info.product_id=order_info.order_product and order_info.order_user=user_info.user_id and user_job='上班族' GROUP BY order_product Order By product_sum desc LIMIT 0,10\n")
    List<Sales> getOrderSumbyUserJob4();

    @Select("SELECT user_info.user_sex,SUM(order_info.order_population) order_sum FROM order_info,user_info WHERE order_info.order_user=user_info.user_id GROUP BY user_sex\n")
    List<UserOrderBySex> getOrderBySex();

    @Select(" SELECT user_info.user_job,SUM(order_info.order_population) user_sum FROM order_info,user_info WHERE order_info.order_user=user_info.user_id GROUP BY user_job\n")
    List<UserSumByJob> getSumByUserJob();

    @Select("SELECT MONTH(order_info.order_create_date) as 'month',SUM(order_info.order_population) as order_sum FROM order_info GROUP BY MONTH(order_create_date)")
    List<OrderByMonth> getSumByMonth();

    @Select("SELECT MONTH(order_info.order_create_date) as 'month',SUM(order_info.order_population) as order_sum FROM order_info,product_info where order_info.order_product=product_info.product_id and product_id=#{product_id} GROUP BY MONTH(order_create_date)")
    List<OrderByMonth> getSumByMonthByPro(Integer product_id);

    @Select("SELECT user_info.user_sex,SUM(order_info.order_population) order_sum FROM order_info,user_info WHERE order_info.order_user=user_info.user_id and order_product=#{product_id} GROUP BY user_sex\n")
    List<UserOrderBySex> getOrderBySexPro(Integer product_id);

    @Select(" SELECT user_info.user_job,SUM(order_info.order_population) user_sum FROM order_info,user_info WHERE order_info.order_user=user_info.user_id and order_product=#{product_id} GROUP BY user_job\n")
    List<UserSumByJob> getSumByUserJobPro(Integer product_id);

    @Select("select order_info.*,user_info.user_name,product_info.product_name,com_info.com_name from order_info,user_info,product_info,com_info where order_info.order_user=user_info.user_id and product_info.product_com=com_info.com_id and order_info.order_product=product_info.product_id and com_info.com_id = #{com_id}")
    List<OrderInfo> getOrderInfoByComId(String com_id);

    @Select("select order_user,product_name,order_price,product_starttime,product_endtime,order_create_date from order_info,product_info where order_product=product_id and order_user=#{user_id}")
    List<UserOrderInfo> getOrderInfoByUserID(String user_id);

    @Insert("Insert INTO order_info (order_id,order_user,order_product,order_population,order_price,order_ispaid,order_active,order_create_date) VALUES (#{order_id},#{order_user},#{order_product},#{order_population},#{order_price},#{order_ispaid},#{order_active},#{order_create_date})")
    Integer addOrderList(Order order);

}
