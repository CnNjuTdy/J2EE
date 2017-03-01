package com.hotelworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tondiyee on 2017/2/22.
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addHotel() {
        return null;
    }

    @RequestMapping(value = "/checkIn", method = RequestMethod.POST)
    public ModelAndView checkIn() {
        return null;
    }

    @RequestMapping(value = "/setting", method = RequestMethod.POST)
    public ModelAndView setUpHotel() {
        return null;
    }

    @RequestMapping(value ="/statistic",method = RequestMethod.POST)
    public ModelAndView checkHotel(){
        return null;
    }
}
