package com.twentytwo.travelweb.entity;

import java.time.Month;

public class OrderPriceByMonth {
    private Month month;
    private double sum_price;

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public double getSum_price() {
        return sum_price;
    }

    public void setSum_price(double sum_price) {
        this.sum_price = sum_price;
    }
}
