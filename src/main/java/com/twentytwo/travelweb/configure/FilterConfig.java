package com.twentytwo.travelweb.configure;

import com.twentytwo.travelweb.filter.AdminLoginFilter;
import com.twentytwo.travelweb.filter.CompanyLoginFilter;
import com.twentytwo.travelweb.filter.UserLoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<AdminLoginFilter> LoginAdmin(){
        FilterRegistrationBean<AdminLoginFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new AdminLoginFilter());
        bean.setName("AdminFilter");
        bean.addUrlPatterns("/admin/*");
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<UserLoginFilter> LoginUser(){
        FilterRegistrationBean<UserLoginFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new UserLoginFilter());
        bean.setName("UserFilter");
        bean.addUrlPatterns("/user/*");
        bean.setOrder(2);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<CompanyLoginFilter> LoginCompany(){
        FilterRegistrationBean<CompanyLoginFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new CompanyLoginFilter());
        bean.setName("CompanyFilter");
        bean.addUrlPatterns("/company/*");
        bean.setOrder(3);
        return bean;
    }
}
