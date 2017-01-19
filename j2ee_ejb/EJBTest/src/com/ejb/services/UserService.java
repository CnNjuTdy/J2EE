package com.ejb.services;

import javax.ejb.Remote;

/**
 * Created by Tondiyee on 2016/12/28.
 */

@Remote
public interface UserService {

    public boolean login(String username, String password);

}
