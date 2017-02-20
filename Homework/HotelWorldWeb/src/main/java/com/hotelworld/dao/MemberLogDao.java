package com.hotelworld.dao;

import com.hotelworld.entity.MemberLog;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public interface MemberLogDao {
    public void saveMemberLog(MemberLog memberLog);

    public void delMemberLog(MemberLog memberLog);

    public void updateMemberLog(MemberLog memberLog);

    public MemberLog findMemberLogById(String id);
}
