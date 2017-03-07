package com.hotelworld.entity.state;

/**
 * Created by Tondiyee on 2017/2/3.
 */

/**
 * 后面三种状态可以稳定长时间存在
 * 转换表：
 * 预备->成功入住：入住登记
 * 预备->取消：取消
 * 成功入住->完结：总经理结算这个订单
 * 预备->超时：超过当天下午6点未登记
 * 也可以不通过预定直接进入成功入住状态
 */
public enum OrderState {
    //预备阶段，此时可以取消
    READINESS,
    //成功入住
    CHECK_IN,
    //取消
    CANCEL,
    //完结
    OVER,
    //超时
    OVERTIME
}
