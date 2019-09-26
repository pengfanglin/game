package com.game.service.admin.impl;

import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.others.BusinessException;
import com.fanglin.common.core.page.Page;
import com.fanglin.common.core.page.PageResult;
import com.fanglin.common.util.*;
import com.game.entity.member.MemberEntity;
import com.game.entity.member.MemberFlowWaterEntity;
import com.game.enums.member.MemberFlowWaterTypeEnum;
import com.game.mapper.MapperFactory;
import com.game.model.admin.member.AddMemberModel;
import com.game.model.admin.member.MemberListModel;
import com.game.model.admin.member.MemberListSearch;
import com.game.model.admin.member.UpdateMemberModel;
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
    public void addMember(AddMemberModel member) {
        ValidatorUtils.validate(member);
        try {
            Long.parseLong(member.getAccount());
        } catch (Exception e) {
            throw new BusinessException("账号只能为数字");
        }
        MemberEntity memberEntity = new MemberEntity().setAccount(member.getAccount());
        int count = mapperFactory.member.selectCount(memberEntity);
        Assert.isTrue(count == 0, "账号已存在");
        memberEntity.setSalt(UUID.randomUUID().toString().replace("-", ""))
            .setPassword(EncodeUtils.md5Encode(member.getPassword(), memberEntity.getSalt()))
            .setUsername(member.getUsername())
            .setCompanyId(member.getCompanyId())
            .setHeadImage(member.getHeadImage())
            .setMobile(member.getMobile());
        mapperFactory.member.insertSelective(memberEntity);
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

    @Override
    public void updateMember(UpdateMemberModel member) {
        ValidatorUtils.validate(member);
        MemberEntity memberEntity = mapperFactory.member.accountExist(member.getAccount());
        if (OthersUtils.notEmpty(member.getAccount())) {
            try {
                Long.parseLong(member.getAccount());
            } catch (Exception e) {
                throw new BusinessException("账号只能为数字");
            }
            Assert.isTrue(memberEntity == null || member.getId().equals(memberEntity.getId()), "账号已存在");
        }
        memberEntity = BeanUtils.copy(member, MemberEntity.class);
        if (OthersUtils.notEmpty(member.getPassword())) {
            String salt = mapperFactory.member.getSlat(member.getId());
            memberEntity.setPassword(EncodeUtils.md5Encode(member.getPassword(), salt));
        }
        int count = mapperFactory.member.updateByPrimaryKeySelective(memberEntity);
        Assert.isTrue(count > 0, "修改失败");
    }
}
