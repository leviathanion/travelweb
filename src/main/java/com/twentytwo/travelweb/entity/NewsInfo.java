package com.twentytwo.travelweb.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsInfo {
    private int news_id;
    private String news_title;
    private String news_content;
    private String news_img_url;
    private int news_product;
    private Date news_create_date;
    private String product_name;
    private String com_name;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_img_url() {
        return news_img_url;
    }

    public void setNews_img_url(String news_img_url) {
        this.news_img_url = news_img_url;
    }

    public int getNews_product() {
        return news_product;
    }

    public void setNews_product(int news_product) {
        this.news_product = news_product;
    }

    public String getNews_create_date() {
        if(news_create_date==null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String create_time = sdf.format(news_create_date);
        return create_time;
    }

    public void setNews_create_date(Date news_create_date) {
        this.news_create_date = news_create_date;
    }
}
