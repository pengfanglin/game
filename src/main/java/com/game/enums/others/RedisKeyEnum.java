package com.game.enums.others;

import lombok.Getter;

/**
 * redis前缀
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 14:06
 **/
public enum RedisKeyEnum {

    /**
     * 验证码
     */
    CODE("code"),
    ACCESS_TOKEN("ACCESS_TOKEN"),
    REFRESH_TOKEN("REFRESH_TOKEN");

    @Getter
    private String key;

    RedisKeyEnum(String key) {
        this.key = key;
    }
}
