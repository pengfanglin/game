package com.game.service.app.impl;

import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.token.TokenInfo;
import com.fanglin.common.util.*;
import com.game.core.others.AppTokenData;
import com.game.entity.member.MemberEntity;
import com.game.mapper.MapperFactory;
import com.game.model.app.member.MemberLoginResultModel;
import com.game.model.app.member.MemberModel;
import com.game.service.app.AppMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * 用户服务实现类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@Service
public class AppMemberServiceImpl implements AppMemberService {

    @Autowired
    MapperFactory mapperFactory;

    @Override
    public MemberLoginResultModel login(HttpServletResponse response, String account, String password) {
        MemberModel member = mapperFactory.member.login(account);
        Assert.notNull(member, "用户不存在");
        Assert.isFalse(member.getDisable(), "账号已冻结");
        Assert.isTrue(EncodeUtils.md5Encode(password, member.getSalt()).equals(member.getPassword()), "密码错误");
        AppTokenData tokenData = new AppTokenData().setId(member.getId());
        TokenInfo tokenInfo = new TokenInfo().setData(tokenData).setType("member");
        TokenUtils.login(response, tokenInfo);
        return new MemberLoginResultModel(tokenInfo.getAssessToken(), tokenInfo.getRefreshToken());
    }

    @Override
    public MemberLoginResultModel register(HttpServletResponse response, String account, String password) {
        Assert.isTrue(account.length() <= 20, "账号最多20个字符");
        Assert.isTrue(password.length() <= 20, "密码最多20个字符");
        MemberEntity member = new MemberEntity().setAccount(account);
        int count = mapperFactory.member.selectCount(member);
        Assert.isTrue(count == 0, "账号已存在");
        member.setSalt(UUID.randomUUID().toString().replace("-", ""))
            .setPassword(EncodeUtils.md5Encode(password, member.getSalt()));
        mapperFactory.member.insertSelective(member);
        AppTokenData tokenData = new AppTokenData().setId(member.getId());
        TokenInfo tokenInfo = new TokenInfo().setData(tokenData).setType("member");
        TokenUtils.login(response, tokenInfo);
        return new MemberLoginResultModel(tokenInfo.getAssessToken(), tokenInfo.getRefreshToken());
    }
}
