package com.twentytwo.travelweb.entity;

import java.time.Month;

public class OrderByMonth {
    private Month month;
    private int order_sum;

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getOrder_sum() {
        return order_sum;
    }

    public void setOrder_sum(int order_sum) {
        this.order_sum = order_sum;
    }
}
