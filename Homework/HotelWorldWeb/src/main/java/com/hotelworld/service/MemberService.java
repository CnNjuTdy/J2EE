package com.hotelworld.service;

import com.hotelworld.entity.Member;
import com.hotelworld.util.WebMessage;

/**
 * Created by Tondiyee on 2017/2/2.
 */
public interface MemberService {
    //注册用户 普通人->非会员
    public WebMessage register(Member member);
    //办理会员 非会员->未激活会员
    public WebMessage join(Member member);
    //停止会员 激活会员->非会员
    public WebMessage stop(Member member);
    //充值    激活会员->激活会员 非激活会员->激活会员
    public WebMessage recharge(Member member,int money);
}
