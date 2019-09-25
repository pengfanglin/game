package com.game.service.admin;


import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.game.model.admin.member.AddMemberModel;
import com.game.model.admin.member.MemberListModel;
import com.game.model.admin.member.MemberListSearch;

/**
 * 后台用户服务
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface AdminMemberService {


    /**
     * 会员列表
     *
     * @return
     */
    PageResult<MemberListModel> memberList(MemberListSearch search, Page page);

    /**
     * 增加会员
     * @param member 会员信息
     */
    void addMember(AddMemberModel member);

    /**
     * 删除会员
     * @param id 会员id
     */
    void deleteMember(Integer id);

    /**
     * 充值
     * @param memberId 会员id
     * @param value 充值金额
     */
    void topUp(Integer memberId, Float value);
}
