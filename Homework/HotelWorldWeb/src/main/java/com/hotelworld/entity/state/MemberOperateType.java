package com.hotelworld.entity.state;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public enum MemberOperateType {
    //注册,注册时触发
    REGISTER,
    //开通,开通时触发
    JOIN,
    //激活,激活时触发
    ACTIVATE,
    //消费,订单被结算时触发
    CONSUME,
    //充值,充值时触发
    RECHARGE,

    //暂停,暂停时触发
    PAUSE,

    //停止,停止时候触发
    STOP
}
