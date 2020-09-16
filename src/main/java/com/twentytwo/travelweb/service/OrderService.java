package com.twentytwo.travelweb.service;

import com.twentytwo.travelweb.entity.*;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    List<OrderInfo> getAllOrderInfo();
    Integer deleteOrder(Integer order_id);
    List<Sales> getOrderNums();
    List<Sales> getMaleUserOrders();
    List<Sales> getFeMaleUserOrders();
    List<Sales> getOrderSumbyUserJob1();
    List<Sales> getOrderSumbyUserJob2();
    List<Sales> getOrderSumbyUserJob3();
    List<Sales> getOrderSumbyUserJob4();
    List<UserOrderBySex> getOrderBySex();
    List<UserSumByJob> getSumByUserJob();
    List<OrderByMonth> getSumByMonth();
    List<OrderByMonth> getSumByMonthByPro(Integer product_id);
    List<UserOrderBySex> getOrderBySexPro(Integer product_id);
    List<UserSumByJob> getSumByUserJobPro(Integer product_id);
    List<OrderInfo> getOrderInfoByComId(String com_id);
    List<UserOrderInfo> getOrderInfoByUserID(String user_id);
    Integer addOrderList(Order order);
    List<Sales> getOrderSumByComId(String com_id);
    List<OrderSumPrice> getOrderPriceSumByComId(String com_id);
    List<UserOrderBySex> getUserOrderBySexCom(String com_id);
    List<UserSumByJob> getOrderSumByJobCom(String com_id);
    List<OrderByMonth> getSumByMonthCom(String com_id);
    List<OrderPriceByMonth> getOrderSumPriceByComMonth(String com_id);
    List<OrderPriceByMonth> getPriceSumByMonthPro(Integer product_id);
}
