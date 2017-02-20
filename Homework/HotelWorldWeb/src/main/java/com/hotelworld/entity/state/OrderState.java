package com.hotelworld.entity.state;

/**
 * Created by Tondiyee on 2017/2/3.
 */

/**
 * 后面两种状态可以稳定长时间存在
 * 转换表：
 * 预备->成功入住：开始日期当天下午6点未取消
 * 预备->取消：开始日期当天下午6点之前取消
 * 成功入住->完结：会员确认付款，非会员结束日期第二天的12时
 */
public enum OrderState {
    //预备阶段，此时可以取消
    READINESS,
    //成功入住
    CHECK_IN,
    //取消
    CANCEL,
    //完结
    OVER
}
