package com.hotelworld.service;

import com.hotelworld.entity.Member;
import com.hotelworld.util.WebMessage;
import com.hotelworld.util.WebObject;

/**
 * Created by Tondiyee on 2017/2/2.
 */
public interface MemberService {
    //注册用户 普通人->非会员
    public WebMessage register(String name,String password,String phone,String account);
    //办理会员 非会员->未激活会员
    public WebMessage join(Member member);
    //停止会员 激活会员->非会员
    public WebMessage stop(Member member);
    //充值    激活会员->激活会员 非激活会员->激活会员
    public WebMessage recharge(Member member,int money);
    //兑换 10积分兑换1元余额
    public WebMessage exchange(Member member);


}
