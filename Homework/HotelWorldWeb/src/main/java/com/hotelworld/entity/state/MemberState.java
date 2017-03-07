package com.hotelworld.entity.state;

/**
 * Created by Tondiyee on 2017/2/1.
 */

/**
 * 转换表
 * 刚注册的用户在停止状态
 * 停止->未激活：直接开通即可；未激活->停止：1年未充值
 * 未激活->激活：充值1000元；激活->未激活：激活后1年余额少于10元
 * 激活->停止：手动取消
 */
public enum MemberState {
    //停止状态，即非会员
    CLOSED,
    //已开通会员，未激活（暂停）
    INACTIVE,
    //激活状态
    ACTIVE
}
