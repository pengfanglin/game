package com.game.controller.app;

import com.fanglin.common.core.others.Ajax;
import com.game.model.app.user.UserLoginResultModel;
import com.game.service.app.AppUserService;
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
@RequestMapping("/app/user/")
@Api(value = "/app/user/", tags = {"APP","用户"})
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @ApiOperation("用户登录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "mobile", value = "手机号", required = true),
        @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @PostMapping("login")
    public Ajax<UserLoginResultModel> login(HttpServletResponse response, @RequestParam String mobile, @RequestParam String password) {
        return Ajax.ok(appUserService.login(response, mobile, password));
    }

    @ApiOperation("用户注册")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "mobile", value = "手机号", required = true),
        @ApiImplicitParam(name = "password", value = "密码", required = true),
        @ApiImplicitParam(name = "code", value = "验证码", required = true)
    })
    @PostMapping("userRegister")
    public Ajax<UserLoginResultModel> register(HttpServletResponse response, @RequestParam String mobile, @RequestParam String password, @RequestParam String code) {
        return Ajax.ok(appUserService.register(response, mobile, password, code));
    }
}
