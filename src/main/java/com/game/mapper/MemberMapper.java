package com.game.mapper;

import com.game.entity.member.MemberEntity;
import com.game.model.admin.member.MemberListModel;
import com.game.model.admin.member.MemberListSearch;
import com.game.model.app.member.MemberModel;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 会员
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
public interface MemberMapper extends Mapper<MemberEntity> {


    /**
     * 会员登录
     *
     * @param account 账号
     * @return
     */
    @Select("select id,password,salt,disable from member where account=#{account}")
    MemberModel login(@Param("mobile") String account);

    /**
     * 会员列表
     *
     * @param rowBounds
     * @return
     */
    List<MemberListModel> memberList(MemberListSearch search, PageRowBounds rowBounds);

    /**
     * 增加余额
     *
     * @param memberId 会员id
     * @param value    金额
     * @return
     */
    @Update("UPDATE member SET balance=balance+#{value} WHERE id=#{memberId}")
    int addBalance(@Param("memberId") Integer memberId, @Param("value") Float value);
}
