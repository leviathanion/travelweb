package com.twentytwo.travelweb.entity;

import java.util.Date;

public class Order {
    private int order_id;
    private String order_user;
    private int order_product;
    private int order_population;
    private double order_price;
    private boolean order_ispaid;
    private boolean order_active;
    private Date order_create_date;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_user() {
        return order_user;
    }

    public void setOrder_user(String order_user) {
        this.order_user = order_user;
    }


    public int getOrder_product() {
        return order_product;
    }

    public void setOrder_product(int order_product) {
        this.order_product = order_product;
    }

    public int getOrder_population() {
        return order_population;
    }

    public void setOrder_population(int order_population) {
        this.order_population = order_population;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public boolean isOrder_ispaid() {
        return order_ispaid;
    }

    public void setOrder_ispaid(boolean order_ispaid) {
        this.order_ispaid = order_ispaid;
    }

    public boolean isOrder_active() {
        return order_active;
    }

    public void setOrder_active(boolean order_active) {
        this.order_active = order_active;
    }

    public Date getOrder_create_date() {
        return order_create_date;
    }

    public void setOrder_create_date(Date order_create_date) {
        this.order_create_date = order_create_date;
    }
}
