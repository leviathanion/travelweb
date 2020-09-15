package com.twentytwo.travelweb.entity;

public class UserOrderBySex {
    private boolean user_sex;
    private int order_sum;

    public boolean isUser_sex() {
        return user_sex;
    }

    public void setUser_sex(boolean user_sex) {
        this.user_sex = user_sex;
    }

    public int getOrder_sum() {
        return order_sum;
    }

    public void setOrder_sum(int order_sum) {
        this.order_sum = order_sum;
    }
}
