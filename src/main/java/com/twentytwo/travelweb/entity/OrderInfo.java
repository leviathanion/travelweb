package com.twentytwo.travelweb.entity;

import java.util.Date;

public class OrderInfo {
    private int order_id;
    private int order_user;
    private int order_com;
    private int order_product;
    private int order_population;
    private double order_price;
    private boolean order_ispaid;
    private boolean order_active;
    private Date order_create_date;
    private String user_name;
    private String com_name;
    private String product_name;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_user() {
        return order_user;
    }

    public void setOrder_user(int order_user) {
        this.order_user = order_user;
    }

    public int getOrder_com() {
        return order_com;
    }

    public void setOrder_com(int order_com) {
        this.order_com = order_com;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
