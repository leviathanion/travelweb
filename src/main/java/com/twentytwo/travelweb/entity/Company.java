package com.twentytwo.travelweb.entity;

import com.twentytwo.travelweb.util.Constant;

import java.util.Date;

public class Company {

    private int com_id;
    private String com_pwd;
    private String com_email;
    private String com_name;
    private int com_privilege;
    private String com_address;
    private boolean com_identify;
    private boolean com_active;
    private Date com_create_date;
    private String privilege;

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getPrivilege(){
        String pr = "";
        switch (this.com_privilege){
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

    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public String getCom_pwd() {
        return com_pwd;
    }

    public void setCom_pwd(String com_pwd) {
        this.com_pwd = com_pwd;
    }

    public String getCom_email() {
        return com_email;
    }

    public void setCom_email(String com_email) {
        this.com_email = com_email;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public int getCom_privilege() {
        return com_privilege;
    }

    public void setCom_privilege(int com_privilege) {
        this.com_privilege = com_privilege;
    }

    public String getCom_address() {
        return com_address;
    }

    public void setCom_address(String com_address) {
        this.com_address = com_address;
    }

    public boolean isCom_identify() {
        return com_identify;
    }

    public void setCom_identify(boolean com_identify) {
        this.com_identify = com_identify;
    }

    public boolean isCom_active() {
        return com_active;
    }

    public void setCom_active(boolean com_active) {
        this.com_active = com_active;
    }

    public Date getCom_create_date() {
        return com_create_date;
    }

    public void setCom_create_date(Date com_create_date) {
        this.com_create_date = com_create_date;
    }
}
