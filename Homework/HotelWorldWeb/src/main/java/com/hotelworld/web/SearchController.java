package com.hotelworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tondiyee on 2017/2/27.
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @RequestMapping(value = "/member",method = RequestMethod.POST)
    public ModelAndView searchMember(){
        return null;
    }
    @RequestMapping(value = "/hotel",method = RequestMethod.POST)
    public ModelAndView searchHotel(){
        return null;
    }
}
