package com.twentytwo.travelweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twentytwo.travelweb.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@ResponseBody
public class UserController {
    @GetMapping("findUserServlet")
    public void FindUserServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String user_id;
        if(request.getSession().getAttribute("user") == null){
            user_id = null;
        }
        else {
            user_id = request.getSession().getAttribute("user").toString();
        }


        response.setContentType("application/json;charset=utf-8 ");
        myWriteValue(response,user_id);
    }

    @GetMapping("quitServlet")
    public void QuitServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();

        response.sendRedirect(request.getContextPath()+"/register/login");
    }

    private void myWriteValue(HttpServletResponse response, Object object) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        mapper.writeValue(response.getOutputStream(),object);
    }
}

