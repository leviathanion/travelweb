package com.twentytwo.travelweb.serviceimpl;

import com.twentytwo.travelweb.entity.Order;
import com.twentytwo.travelweb.entity.OrderInfo;
import com.twentytwo.travelweb.mapper.OrderMapper;
import com.twentytwo.travelweb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> getAllOrders() {
        return orderMapper.getAllOrders();
    }

    @Override
    public List<OrderInfo> getAllOrderInfo() {
        return orderMapper.getAllOrderInfo();
    }

    @Override
    public Integer deleteOrder(Integer order_id) {
        return orderMapper.deleteOrder(order_id);
    }
}
