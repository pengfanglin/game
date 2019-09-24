package com.game.service.admin.impl;

import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.others.BusinessException;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.fanglin.common.core.token.TokenInfo;
import com.fanglin.common.util.EncodeUtils;
import com.fanglin.common.util.PageUtils;
import com.fanglin.common.util.TokenUtils;
import com.game.core.others.AppTokenData;
import com.game.entity.member.MemberEntity;
import com.game.entity.member.MemberFlowWaterEntity;
import com.game.enums.member.MemberFlowWaterTypeEnum;
import com.game.mapper.MapperFactory;
import com.game.model.admin.member.MemberListModel;
import com.game.model.admin.member.MemberListSearch;
import com.game.model.app.member.MemberLoginResultModel;
import com.game.service.admin.AdminMemberService;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;


/**
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@Service
public class AdminMemberServiceImpl implements AdminMemberService {

    @Autowired
    MapperFactory mapperFactory;


    @Override
    public PageResult<MemberListModel> memberList(MemberListSearch search, Page page) {
        PageRowBounds rowBounds = PageUtils.rowBounds(page);
        return new PageResult<>(mapperFactory.member.memberList(search, rowBounds), rowBounds.getTotal());
    }

    @Override
    public void addMember(String account, String password) {
        Assert.isTrue(account.length() <= 10, "账号最多10个字符");
        Assert.isTrue(account.length() >= 3, "账号最少3个字符");
        try {
            Long.parseLong(account);
        } catch (Exception e) {
            throw new BusinessException("账号只能为数字");
        }
        Assert.isTrue(password.length() <= 20, "密码最多20个字符");
        MemberEntity member = new MemberEntity().setAccount(account);
        int count = mapperFactory.member.selectCount(member);
        Assert.isTrue(count == 0, "账号已存在");
        member.setSalt(UUID.randomUUID().toString().replace("-", ""))
            .setPassword(EncodeUtils.md5Encode(password, member.getSalt()));
        mapperFactory.member.insertSelective(member);
    }

    @Override
    public void deleteMember(Integer id) {
        int count = mapperFactory.member.deleteByPrimaryKey(id);
        Assert.isTrue(count > 0, "删除失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void topUp(Integer memberId, Float value) {
        Assert.isTrue(value > 0, "充值金额不合法");
        int count = mapperFactory.member.addBalance(memberId, value);
        Assert.isTrue(count > 0, "修改用户余额失败");
        count = mapperFactory.memberFlowWater.insertSelective(
            new MemberFlowWaterEntity().setMember_id(memberId).setType(MemberFlowWaterTypeEnum.ADMIN_TOP_UP).setValue(new BigDecimal(value))
        );
        Assert.isTrue(count > 0, "会员流水添加失败");
    }
}
