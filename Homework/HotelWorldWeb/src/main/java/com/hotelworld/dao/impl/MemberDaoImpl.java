package com.hotelworld.dao.impl;

import com.hotelworld.dao.BaseDao;
import com.hotelworld.dao.MemberDao;
import com.hotelworld.entity.Member;
import com.hotelworld.entity.state.MemberState;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tondiyee on 2017/2/1.
 */
@Repository
public class MemberDaoImpl extends BaseDaoImpl implements MemberDao {
    public void saveMember(Member member) {
        template.save(member);
    }

    public Member findMemberById(String id) {
        return template.get(Member.class,id);
    }

    public void updateMember(Member member){
        template.update(member);
    }

    public void delMember(Member member){
        template.delete(member);
    }

}
