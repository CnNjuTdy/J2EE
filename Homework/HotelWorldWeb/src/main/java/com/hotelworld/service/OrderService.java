package com.hotelworld.service;

import com.hotelworld.entity.Order;
import com.hotelworld.util.WebMessage;
import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * Created by Tondiyee on 2017/3/1.
 */
public interface OrderService {
    //生成方式1：会员预定，此时订单状态是预备
    //生成方式2：普通人直接入店，此时订单状态是成功入住
    public WebMessage createOrder(Order order);

    //取消方式：会员在开始日期当天6点之前在网上取消，普通顾客不能取消
    public WebMessage cancelOrder(Order order);

    //结算方式：总经理结算某个订单()
    public WebMessage settleOrder(Order order);
}
