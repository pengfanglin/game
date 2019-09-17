package com.game.service.app;

import com.game.model.app.member.MemberLoginResultModel;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户服务
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface AppMemberService {

    /**
     * 会员登录
     *
     * @param response
     * @param account  账号
     * @param password 密码
     * @return
     */
    MemberLoginResultModel login(HttpServletResponse response, String account, String password);

    /**
     * 会员注册
     *
     * @param response
     * @param account  手机号
     * @param password 密码
     * @return
     */
    MemberLoginResultModel register(HttpServletResponse response, String mobile, String password);
}
