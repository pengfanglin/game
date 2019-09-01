package com.game.enums.others;

import lombok.Getter;

/**
 * 验证码类型
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/16 20:27
 **/
public enum CodeTypeEnum {

    /**
     * 验证码
     */
    CODE("SMS_173246287"),
    /**
     * 用户注册
     */
    USER_REGISTER("SMS_173246287");

    @Getter
    private String code;

    CodeTypeEnum(String code) {
        this.code = code;
    }
}
