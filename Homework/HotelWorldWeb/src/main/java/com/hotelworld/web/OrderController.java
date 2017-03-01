package com.hotelworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tondiyee on 2017/2/22.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addOrder(){
        return null;
    }
    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
    public ModelAndView cancelOrder(){
        return null;
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ModelAndView listAllOrder(){
        return null;
    }
    @RequestMapping(value = "/confirm",method = RequestMethod.POST)
    public ModelAndView confirmOrder(){
        return null;
    }
}
