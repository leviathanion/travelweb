package com.twentytwo.travelweb.serviceimpl;

import com.twentytwo.travelweb.entity.*;
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

    @Override
    public List<Sales> getOrderNums() {
        return orderMapper.getOrderNums();
    }

    @Override
    public List<Sales> getMaleUserOrders() {
        return orderMapper.getMaleUserOrders();
    }

    @Override
    public List<Sales> getFeMaleUserOrders() {
        return orderMapper.getFeMaleUserOrders();
    }

    @Override
    public List<Sales> getOrderSumbyUserJob1() {
        return orderMapper.getOrderSumbyUserJob1();
    }

    @Override
    public List<Sales> getOrderSumbyUserJob2() {
        return orderMapper.getOrderSumbyUserJob2();
    }

    @Override
    public List<Sales> getOrderSumbyUserJob3() {
        return orderMapper.getOrderSumbyUserJob3();
    }

    @Override
    public List<Sales> getOrderSumbyUserJob4() {
        return orderMapper.getOrderSumbyUserJob4();
    }

    @Override
    public List<UserOrderBySex> getOrderBySex() {
        return orderMapper.getOrderBySex();
    }

    @Override
    public List<UserSumByJob> getSumByUserJob() {
        return orderMapper.getSumByUserJob();
    }

    @Override
    public List<OrderByMonth> getSumByMonth() {
        return orderMapper.getSumByMonth();
    }

    @Override
    public List<OrderByMonth> getSumByMonthByPro(Integer product_id) {
        return orderMapper.getSumByMonthByPro(product_id);
    }

    @Override
    public List<UserOrderBySex> getOrderBySexPro(Integer product_id) {
        return orderMapper.getOrderBySexPro(product_id);
    }

    @Override
    public List<UserSumByJob> getSumByUserJobPro(Integer product_id) {
        return orderMapper.getSumByUserJobPro(product_id);
    }

    @Override
    public List<OrderInfo> getOrderInfoByComId(String com_id) {
        return orderMapper.getOrderInfoByComId(com_id);
    }

    @Override
    public List<UserOrderInfo> getOrderInfoByUserID(String user_id) {
        return orderMapper.getOrderInfoByUserID(user_id);
    }

    @Override
    public Integer addOrderList(Order order) {
        return orderMapper.addOrderList(order);
    }

    @Override
    public List<Sales> getOrderSumByComId(String com_id) {
        return orderMapper.getOrderSumByComId(com_id);
    }

    @Override
    public List<OrderSumPrice> getOrderPriceSumByComId(String com_id) {
        return orderMapper.getOrderPriceSumByComId(com_id);
    }

    @Override
    public List<UserOrderBySex> getUserOrderBySexCom(String com_id) {
        return orderMapper.getUserOrderBySexCom(com_id);
    }

    @Override
    public List<UserSumByJob> getOrderSumByJobCom(String com_id) {
        return orderMapper.getOrderSumByJobCom(com_id);
    }

    @Override
    public List<OrderByMonth> getSumByMonthCom(String com_id) {
        return orderMapper.getSumByMonthCom(com_id);
    }

    @Override
    public List<OrderPriceByMonth> getOrderSumPriceByComMonth(String com_id) {
        return orderMapper.getOrderSumPriceByComMonth(com_id);
    }

    @Override
    public List<OrderPriceByMonth> getPriceSumByMonthPro(Integer product_id) {
        return orderMapper.getPriceSumByMonthPro(product_id);
    }

    @Override
    public List<UserOrderInfo> getOrderInfoByUser(String user_id) {
        return orderMapper.getOrderInfoByUser(user_id);
    }

    @Override
    public Integer updateOrderInfo(Integer order_id) {
        return orderMapper.updateOrderInfo(order_id);
    }

    @Override
    public Integer unSubscribeOrder(Integer order_id) {
        return orderMapper.unSubscribeOrder(order_id);
    }
}
