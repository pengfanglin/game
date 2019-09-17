package com.game.controller.app;

import com.fanglin.common.core.others.Ajax;
import com.game.model.app.member.MemberLoginResultModel;
import com.game.service.app.AppMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@RestController
@RequestMapping("/app/member/")
@Api(value = "/app/member/", tags = {"APP-会员"})
public class AppMemberController {

    @Autowired
    AppMemberService appMemberService;

    @ApiOperation("登录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "account", value = "账号", required = true),
        @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @PostMapping("login")
    public Ajax<MemberLoginResultModel> login(HttpServletResponse response, @RequestParam String account, @RequestParam String password) {
        return Ajax.ok(appMemberService.login(response, account, password));
    }

    @ApiOperation("注册")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "account", value = "账号", required = true),
        @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @PostMapping("register")
    public Ajax<MemberLoginResultModel> register(HttpServletResponse response, @RequestParam String account, @RequestParam String password) {
        return Ajax.ok(appMemberService.register(response, account, password));
    }
}
