package com.hotelworld.service;

import com.hotelworld.entity.Application;
import com.hotelworld.util.WebMessage;

/**
 * 总经理主要的事情包括给分店结账，审批申请，查看统计信息（search里面完成）
 * Created by Tondiyee on 2017/3/2.
 */
public interface HeadManagerService {
    /**
     * 使用者：总经理
     * 使用时机：给分店结账的时候
     * 给分店结账
     * @param hotelId
     * @return
     */
    public WebMessage settleByHotel(String hotelId);

    /**
     * 使用者：总经理
     * 使用时机：批准申请
     * @param application
     * @return
     */
    public WebMessage agreeApplication(Application application);

    /**
     * 使用者：总经理
     * 使用时机：不批准申请
     * @param application
     * @return
     */
    public WebMessage disagreeApplication(Application application);

}
