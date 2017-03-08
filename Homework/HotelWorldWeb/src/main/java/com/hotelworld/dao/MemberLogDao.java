package com.hotelworld.dao;

import com.hotelworld.entity.MemberLog;

import java.util.List;

/**
 * Created by Tondiyee on 2017/2/3.
 */
public interface MemberLogDao {
    public void saveMemberLog(MemberLog memberLog);

    public void delMemberLog(MemberLog memberLog);

    public void updateMemberLog(MemberLog memberLog);

    public MemberLog findMemberLogById(String id);
    //返回用户的所有log
    public List<MemberLog> findMemberLogByMember(String memberId);
}
