package com.twentytwo.travelweb.entity;

public class OrderSumPrice {

    private String product_name;
    private double price_sum;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice_sum() {
        return price_sum;
    }

    public void setPrice_sum(double price_sum) {
        this.price_sum = price_sum;
    }
}
