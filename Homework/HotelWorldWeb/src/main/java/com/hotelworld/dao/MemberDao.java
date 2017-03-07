package com.hotelworld.dao;

import com.hotelworld.entity.Member;

import java.util.List;

/**
 * Created by Tondiyee on 2017/2/1.
 */
public interface MemberDao {
    /**
     * 保存一个member实例
     * 未检查是否已经存在该id
     * @param member
     */
    public void saveMember(Member member);

    /**
     * 根据id返回member实例，不存在时返回空
     * @param id
     * @return Member
     */
    public Member findMemberById(String id);


    /**
     * 更新一个member实例
     * 未检查该id是否存在
     * @param member
     */
    public void updateMember(Member member);


    /**
     *删除一个member实例
     * 未检查该id是否存在时
     * @param member
     */
    public void delMember(Member member);

}
