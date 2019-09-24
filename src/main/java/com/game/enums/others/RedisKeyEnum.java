package com.game.enums.others;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * redis前缀
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 14:06
 **/
@AllArgsConstructor
public enum RedisKeyEnum {

    /**
     * 验证码
     */
    CODE("code"),
    /**
     * 鉴权token
     */
    ACCESS_TOKEN("ACCESS_TOKEN"),
    /**
     * 刷新token
     */
    REFRESH_TOKEN("REFRESH_TOKEN");

    @Getter
    private String key;
}
