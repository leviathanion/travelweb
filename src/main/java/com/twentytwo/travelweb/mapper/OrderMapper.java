package com.twentytwo.travelweb.mapper;

import com.twentytwo.travelweb.entity.Order;
import com.twentytwo.travelweb.entity.OrderInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from order_info")
    List<Order> getAllOrders();

    @Select("select order_info.*,user_info.user_name,product_info.product_name,com_info.com_name from order_info,user_info,product_info,com_info where order_info.order_user=user_info.user_id and product_info.product_com=com_info.com_id and order_info.order_product=product_info.product_id")
    List<OrderInfo> getAllOrderInfo();

    @Delete("delete from order_info where order_id=#{order_id}")
    Integer deleteOrder(Integer order_id);

}
