package com.hotelworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tondiyee on 2017/2/22.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/index")
    public String index(){
        return "test/index";
    }
}
