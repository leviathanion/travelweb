package com.twentytwo.travelweb.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserOrderInfo {
    private int order_id;
    private String order_user;
    private String product_name;
    private double order_price;
    private int order_population;
    private Date product_starttime;
    private Date product_endtime;
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

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public int getOrder_population() {
        return order_population;
    }

    public void setOrder_population(int order_population) {
        this.order_population = order_population;
    }

    public String getProduct_starttime() {
        if(product_starttime==null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String starttime = sdf.format(product_starttime);
        return starttime;
    }

    public void setProduct_starttime(Date product_starttime) {
        this.product_starttime = product_starttime;
    }

    public String getProduct_endtime() {
        if(product_endtime==null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String endtime = sdf.format(product_endtime);
        return endtime;
    }

    public void setProduct_endtime(Date product_endtime) {
        this.product_endtime = product_endtime;
    }

    public String getOrder_create_date() {
        if(order_create_date==null){
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String create_time = sdf.format(order_create_date);

        return create_time;
    }

    public void setOrder_create_date(Date order_create_date) {
        this.order_create_date = order_create_date;
    }
}
