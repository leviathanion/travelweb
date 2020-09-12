package com.twentytwo.travelweb.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductInfo {

    private int product_id;
    private String product_com;
    private String product_name;
    private String product_route;
    private double product_price;
    private boolean product_active;
    private Date product_starttime;
    private Date product_endtime;
    private String product_img_url;
    private String product_introduce;
    private int product_click_count;
    private Date product_create_time;
    private String com_name;

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_com() {
        return product_com;
    }

    public void setProduct_com(String product_com) {
        this.product_com = product_com;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_route() {
        return product_route;
    }

    public void setProduct_route(String product_route) {
        this.product_route = product_route;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public boolean isProduct_active() {
        return product_active;
    }

    public void setProduct_active(boolean product_active) {
        this.product_active = product_active;
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

    public String getProduct_img_url() {
        return product_img_url;
    }

    public void setProduct_img_url(String product_img_url) {
        this.product_img_url = product_img_url;
    }

    public String getProduct_introduce() {
        return product_introduce;
    }

    public void setProduct_introduce(String product_introduce) {
        this.product_introduce = product_introduce;
    }

    public int getProduct_click_count() {
        return product_click_count;
    }

    public void setProduct_click_count(int product_click_count) {
        this.product_click_count = product_click_count;
    }

    public Date getProduct_create_time() {
        return product_create_time;
    }

    public void setProduct_create_time(Date product_create_time) {
        this.product_create_time = product_create_time;
    }
}
