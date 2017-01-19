package com.ejb;

import javax.ejb.Remote;

/**
 * Created by Tondiyee on 2017/1/18.
 */
@Remote
public interface HelloWorld {
    public String sayHello(String world);
}
