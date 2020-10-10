package com.twentytwo.travelweb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        if(session==null){
            response.sendRedirect("/register/login");
            return;
        }else if(!"user".equals((String)session.getAttribute("type"))){
            response.sendRedirect("/register/login");
            return;
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
