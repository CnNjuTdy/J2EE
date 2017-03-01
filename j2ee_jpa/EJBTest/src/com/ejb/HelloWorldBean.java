package com.ejb;

import javax.ejb.Stateless;

/**
 * Created by Tondiyee on 2017/1/18.
 */
@Stateless(name = "HelloWorldEJB")
public class HelloWorldBean implements HelloWorld{
    public HelloWorldBean() {
    }

    @Override
    public String sayHello(String world) {
        return "Hello "+world;
    }
}
