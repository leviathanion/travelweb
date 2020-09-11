package com.twentytwo.travelweb.entity;

import com.twentytwo.travelweb.util.Constant;

import java.util.Date;

public class User {
    private int user_id;
    private String user_name;
    private String user_pwd;
    private boolean user_sex;
    private int user_age;
    private String user_address;
    private String user_email;
    private int user_privilege;
    private String user_job;
    private String user_img_url;
    private String user_remark;
    private Date user_create_date;
    private boolean user_active;
    private String privilege;

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getPrivilege(){
        String pr = "";
        switch (this.user_privilege){
            case Constant.PRIVILEGE_ADMIN:
                pr = "管理员";
                break;
            case Constant.PRIVILEGE_USER:
                pr = "用户";
                break;
            case Constant.PRIVILEGE_COMPANY:
                pr = "商家";
                break;
            case Constant.PRIVILEGE_BLACKLIST:
                pr = "黑名单";
                break;
            default:
                break;
        }
        return pr;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public boolean isUser_sex() {
        return user_sex;
    }

    public void setUser_sex(boolean user_sex) {
        this.user_sex = user_sex;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getUser_privilege() {
        return user_privilege;
    }

    public void setUser_privilege(int user_privilege) {
        this.user_privilege = user_privilege;
    }

    public String getUser_job() {
        return user_job;
    }

    public void setUser_job(String user_job) {
        this.user_job = user_job;
    }

    public String getUser_img_url() {
        return user_img_url;
    }

    public void setUser_img_url(String user_img_url) {
        this.user_img_url = user_img_url;
    }

    public String getUser_remark() {
        return user_remark;
    }

    public void setUser_remark(String user_remark) {
        this.user_remark = user_remark;
    }

    public Date getUser_create_date() {
        return user_create_date;
    }

    public void setUser_create_date(Date user_create_date) {
        this.user_create_date = user_create_date;
    }

    public boolean isUser_active() {
        return user_active;
    }

    public void setUser_active(boolean user_active) {
        this.user_active = user_active;
    }
}
