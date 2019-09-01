package com.game.enums.others;

import lombok.Getter;

/**
 * 需要鉴权的验证码类型
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/16 20:27
 **/
public enum AuthCodeTypeEnum {

    /**
     * 找回密码
     */
    FIND_PASSWORD("SMS_173246287"),
    /**
     * 修改密码
     */
    UPDATE_PASSWORD("SMS_173246287");

    @Getter
    private String code;

    AuthCodeTypeEnum(String code) {
        this.code = code;
    }
}
