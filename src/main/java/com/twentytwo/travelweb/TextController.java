package com.twentytwo.travelweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TextController {

    @GetMapping("pro_index")
    public String getText(){
        return "background/pro_privilege";
    }

}
