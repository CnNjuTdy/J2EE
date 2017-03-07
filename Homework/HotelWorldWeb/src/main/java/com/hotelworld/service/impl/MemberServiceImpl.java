package com.hotelworld.service.impl;

import com.hotelworld.dao.MemberDao;
import com.hotelworld.dao.MemberLogDao;
import com.hotelworld.entity.Member;
import com.hotelworld.entity.MemberLog;
import com.hotelworld.entity.state.MemberOperateType;
import com.hotelworld.entity.state.MemberState;
import com.hotelworld.entity.state.WebResultState;
import com.hotelworld.service.MemberService;
import com.hotelworld.util.DateUtil;
import com.hotelworld.util.IdUtil;
import com.hotelworld.util.WebMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tondiyee on 2017/2/2.
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDao dao1;

    @Autowired
    MemberLogDao dao2;

    public WebMessage register(String name, String password, String phone, String account) {
        Member member = new Member(IdUtil.getMemberId(), name, password, phone, 0, 0, account,
                MemberState.CLOSED);
        dao1.saveMember(member);
        MemberLog log = new MemberLog(IdUtil.getMemberLogId(), member.getId(), MemberOperateType.REGISTER,
                0, DateUtil.getToday(), 1);
        dao2.saveMemberLog(log);
        return new WebMessage("注册成功！您还没有开通会员", WebResultState.NORMAL);
    }

    public WebMessage join(Member member) {
        Member memberDB = dao1.findMemberById(member.getId());
        if (memberDB == null) {
            return new WebMessage("用户不存在！", WebResultState.WARNING);
        } else {
            member.setState(MemberState.INACTIVE);
            dao1.updateMember(member);
            MemberLog log = new MemberLog(IdUtil.getMemberLogId(), member.getId(), MemberOperateType.JOIN,
                    0, DateUtil.getToday(), 1);
            return new WebMessage("成功开通会员。会员状态：未激活", WebResultState.NORMAL);
        }
    }

    public WebMessage stop(Member member) {
        Member memberDB = dao1.findMemberById(member.getId());
        if (memberDB == null) {
            return new WebMessage("用户不存在！", WebResultState.WARNING);
        } else {
            member.setState(MemberState.CLOSED);
            dao1.updateMember(member);
            MemberLog log = new MemberLog(IdUtil.getMemberLogId(), member.getId(), MemberOperateType.STOP,
                    0, DateUtil.getToday(), 1);
            dao2.saveMemberLog(log);
            return new WebMessage("成功停止会员。", WebResultState.NORMAL);
        }
    }

    public WebMessage recharge(Member member, int money) {
        Member memberDB = dao1.findMemberById(member.getId());
        if (memberDB == null) {
            return new WebMessage("用户不存在！", WebResultState.WARNING);
        } else if (member.getState() == MemberState.CLOSED) {
            return new WebMessage("用户还未激活！", WebResultState.WARNING);
        } else {
            member.setBalance(member.getBalance() + money);
            //判断其属性
            int balance = member.getBalance();
            MemberState state = member.getState();
            String message = "";
            WebResultState mState = WebResultState.NORMAL;
            if (state == MemberState.ACTIVE) {
                //会员状态不用改变
                message = "成功充值" + money + "元，当前余额：" + balance + "元。";
            } else if (state == MemberState.INACTIVE) {
                if (balance < 1000) {
                    //会员状态不用改变
                    message = "成功充值" + money + "元，余额：" + balance + "元。仍未激活！";
                    MemberLog log = new MemberLog(IdUtil.getMemberLogId(), member.getId(), MemberOperateType.RECHARGE,
                            money, DateUtil.getToday(), 1);
                    dao2.saveMemberLog(log);
                } else if (balance >= 1000) {
                    //未激活->激活
                    message = "成功充值" + money + "元，余额：" + balance + "元。已激活";
                    member.setState(MemberState.ACTIVE);
                    MemberLog log1 = new MemberLog(IdUtil.getMemberLogId(), member.getId(), MemberOperateType.RECHARGE,
                            money, DateUtil.getToday(), 1);
                    dao2.saveMemberLog(log1);
                    MemberLog log2 = new MemberLog(IdUtil.getMemberLogId(), member.getId(), MemberOperateType.ACTIVATE,
                            0, DateUtil.getToday(), 1);
                    dao2.saveMemberLog(log2);
                }
            }
            dao1.updateMember(member);
            WebMessage webMessage = new WebMessage(message, mState);
            return webMessage;
        }
    }

    public WebMessage exchange(Member member) {
        int credits = member.getCredits();
        if (credits <= 0) {
            return new WebMessage("您的积分不足！", WebResultState.WARNING);
        }
        member.addBalance(credits / 10);
        member.setCredits(0);
        dao1.updateMember(member);
        return new WebMessage("积分余额兑换成功，积分：0，余额：" + member.getBalance(), WebResultState.NORMAL);
    }

}
