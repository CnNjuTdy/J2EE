package com.hotelworld.dao.impl;

import com.hotelworld.dao.MemberLogDao;
import com.hotelworld.entity.MemberLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tondiyee on 2017/2/3.
 */
@Repository
public class MemberLogDaoImpl extends BaseDaoImpl implements MemberLogDao {
    public void saveMemberLog(MemberLog memberLog) {
        template.save(memberLog);
    }

    public void delMemberLog(MemberLog memberLog) {
        template.delete(memberLog);
    }

    public void updateMemberLog(MemberLog memberLog) {
        template.update(memberLog);
    }

    public MemberLog findMemberLogById(String id) {
        return template.get(MemberLog.class, id);
    }

    public List<MemberLog> findMemberLogByMember(String memberId) {
        Object[] params = {memberId};
        return findBySQL("select * from member_log where ml_member=?", params, MemberLog.class);
    }
}
