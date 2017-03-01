package com.hotelworld.service;

import com.hotelworld.entity.Member;
import com.hotelworld.util.WebMessage;

/**
 * Created by Tondiyee on 2017/2/2.
 */
public interface MemberService {
    public WebMessage register(Member member);

    public WebMessage join(Member member);

    public WebMessage stop(Member member);

    public WebMessage recharge(Member member,int money);
}
