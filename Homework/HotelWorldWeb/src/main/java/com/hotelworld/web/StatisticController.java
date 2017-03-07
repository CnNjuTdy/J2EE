package com.hotelworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tondiyee on 2017/2/27.
 */
@Controller
@RequestMapping("/statistic")
public class StatisticController {
    //这里可以添加url参数了
    @RequestMapping(value = "/member",method = RequestMethod.POST)
    public ModelAndView statisticMember(){
        return null;
    }
    //这里可以添加url参数了
    @RequestMapping(value = "/hotel",method = RequestMethod.POST)
    public ModelAndView statisticHotel(){
        return null;
    }
    @RequestMapping(value = "/all",method = RequestMethod.POST)
    public ModelAndView statisticAll(){
        return null;
    }
}
