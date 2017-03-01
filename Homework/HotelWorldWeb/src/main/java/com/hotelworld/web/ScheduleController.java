package com.hotelworld.web;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tondiyee on 2017/2/26.
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ModelAndView checkSchedule() {
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addSchedule() {
        return null;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ModelAndView modifySchedule() {
        return null;
    }
}
