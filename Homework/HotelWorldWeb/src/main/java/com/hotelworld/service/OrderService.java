package com.hotelworld.service;

import com.hotelworld.entity.Order;
import com.hotelworld.util.WebMessage;
import com.hotelworld.util.WebObject;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Date;

/**
 * Created by Tondiyee on 2017/3/1.
 */
public interface OrderService {
    //生成方式1：会员预定，此时订单状态是预备,调用时机是预定的时候
    //生成方式2：普通人直接入店，此时订单状态是成功入住，调用时机是check in的时候
    //做完这个方法之后，数据库应该有的改变是：多一个订单，时间段内的room信息变化
    //返回生成的订单
    public WebObject<Order> createOrder(String hotelId, String memberId, int roomType,
                                 Date start);

    //取消方式：会员在开始日期当天6点之前在网上取消，普通顾客不能取消
    public WebMessage cancelOrder(Order order);
}
