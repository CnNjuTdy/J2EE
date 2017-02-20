package com.hotelworld.service.impl;

import com.hotelworld.dao.MemberDao;
import com.hotelworld.entity.Member;
import com.hotelworld.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tondiyee on 2017/2/2.
 */
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberDao dao;

    public void register(Member member) {
        dao.saveMember(member);
    }
}
