package com.game.service.app.impl;

import com.fanglin.common.core.others.Assert;
import com.fanglin.common.core.token.TokenInfo;
import com.fanglin.common.utils.*;
import com.game.core.others.AppTokenData;
import com.game.entity.user.UserEntity;
import com.game.enums.others.CodeTypeEnum;
import com.game.enums.others.RedisKeyEnum;
import com.game.mapper.MapperFactory;
import com.game.model.user.UserLoginResultModel;
import com.game.model.user.UserModel;
import com.game.service.app.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

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
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    MapperFactory mapperFactory;

    @Override
    public UserLoginResultModel login(HttpServletResponse response, String mobile, String password) {
        Assert.isTrue(RegexUtils.checkPhone(mobile), "手机号格式错误");
        UserModel user = mapperFactory.user.login(mobile);
        Assert.notNull(user, "用户不存在");
        Assert.isFalse(user.getDisable(), "账号已冻结");
        Assert.isTrue(EncodeUtils.md5Encode(password, user.getSalt()).equals(user.getPassword()), "密码错误");
        AppTokenData tokenData = new AppTokenData(user.getId(), mobile);
        TokenInfo tokenInfo = new TokenInfo().setData(tokenData).setType("app");
        TokenUtils.login(response, tokenInfo);
        return new UserLoginResultModel(tokenInfo.getAssessToken(), tokenInfo.getRefreshToken());
    }

    @Override
    public UserLoginResultModel register(HttpServletResponse response, String mobile, String password, String code) {
        Assert.isTrue(RegexUtils.checkPhone(mobile), "手机号格式错误");
        Assert.isTrue(password.length() <= 20, "密码最多20位");
        String key = String.format("%s:%s:%s:%s", RedisKeyEnum.CODE.getKey(), CodeTypeEnum.USER_REGISTER, mobile, code);
        try (Jedis jedis = JedisUtils.getJedis()) {
            LogUtils.info(key);
            String value = jedis.get(key);
            Assert.notNull(value, "验证码不存在");
        }
        UserEntity user = new UserEntity().setMobile(Long.valueOf(mobile));
        int count = mapperFactory.user.selectCount(user);
        Assert.isTrue(count == 0, "账号已存在");
        user.setSalt(UUID.randomUUID().toString().replace("-", ""))
            .setPassword(EncodeUtils.md5Encode(password, user.getSalt()));
        mapperFactory.user.insertSelective(user);
        AppTokenData tokenData = new AppTokenData(user.getId(), user.getMobile().toString());
        TokenInfo tokenInfo = new TokenInfo().setData(tokenData).setType("app");
        TokenUtils.login(response, tokenInfo);
        try (Jedis jedis = JedisUtils.getJedis()) {
            jedis.del(key);
        }
        return new UserLoginResultModel(tokenInfo.getAssessToken(), tokenInfo.getRefreshToken());
    }
}
