package com.hotelworld.service;

import com.hotelworld.entity.Application;
import com.hotelworld.entity.CheckInLog;
import com.hotelworld.entity.Hotel;
import com.hotelworld.entity.Order;
import com.hotelworld.entity.state.ApplicationState;
import com.hotelworld.util.WebMessage;

/**
 * 这里有必要说明一下开店流程
 * 注册->申请->等待审批->开店完成
 * 其中等待审批过程就不准备在系统内发出消息了，最多，我是说最多能够发个电子邮件通知一下申请人就不错了……
 * 审批通过之后，hotel信息就加入了hotel表
 *
 * 分店老板主要工作内容：发布计划修改计划（计划里面完成），入店，离店登记，查看财务信息（搜索里面完成）
 * Created by Tondiyee on 2017/3/2.
 */
public interface BranchManagerService {

    /**
     * 注册一个hotel
     * @param
     * @return
     */
    public WebMessage registerHotel(String bossName,String city,String address,int[] rooms) ;

    /**
     * 提交一个申请
     * @return
     */
    public WebMessage submitApplication(Hotel hotel,String info,String mailAddress);
    /**
     * 入店登记，必须有order，如果直接进入的，那么要先生成order，那么log当中当做现金结账计算
     * @param order
     * @param name
     * @param number
     * @return
     */
    public WebMessage checkIn(Order order,String name,String number);

    /**
     * 离店登记，和上面类似
     * @param order
     * @param name
     * @param number
     * @return
     */
    public WebMessage checkOut(Order order,String name,String number);

}
