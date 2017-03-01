package com.hotelworld.web;

import com.hotelworld.entity.Member;
import com.hotelworld.service.MemberService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tondiyee on 2017/2/23.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private MemberService service;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("login/index");
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public ModelAndView login(){
        return null;
    }

    @RequestMapping(value = "/doLogout",method = RequestMethod.POST)
    public ModelAndView logout() {
        return null;
    }
}
