package com.hotelworld.web;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tondiyee on 2017/2/22.
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return null;
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    public ModelAndView stopMember() {
        return null;
    }

    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public ModelAndView rechargeMember() {
        return null;
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public ModelAndView joinMember() {
        return null;
    }
}
