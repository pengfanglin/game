package com.game.service.app;

import com.game.model.app.user.UserLoginResultModel;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户服务
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface AppUserService {

    /**
     * 用户登录
     *
     * @param response
     * @param mobile   手机号
     * @param password 密码
     * @return
     */
    UserLoginResultModel login(HttpServletResponse response, String mobile, String password);

    /**
     * 用户注册
     *
     * @param response
     * @param mobile   手机号
     * @param password 密码
     * @param code     验证码
     * @return
     */
    UserLoginResultModel register(HttpServletResponse response, String mobile, String password, String code);
}
