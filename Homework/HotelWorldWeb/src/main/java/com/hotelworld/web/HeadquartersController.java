package com.hotelworld.web;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tondiyee on 2017/2/22.
 */
@Controller
@RequestMapping("/head")
public class HeadquartersController {
    @RequestMapping(value = "/review",method = RequestMethod.POST)
    public ModelAndView review(){
        return null;
    }

    @RequestMapping(value="/statistic",method = RequestMethod.POST)
    public ModelAndView checkAll(){
        return null;
    }

    @RequestMapping(value = "/settle",method = RequestMethod.POST)
    public ModelAndView settleOrder(){
        return null;
    }
}
