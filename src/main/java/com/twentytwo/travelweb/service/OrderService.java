package com.twentytwo.travelweb.service;

import com.twentytwo.travelweb.entity.Order;
import com.twentytwo.travelweb.entity.OrderInfo;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    List<OrderInfo> getAllOrderInfo();
    Integer deleteOrder(Integer order_id);
}
