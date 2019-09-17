package com.game.enums.others;

import com.fanglin.common.core.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统设置类型
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/16 20:27
 **/
@AllArgsConstructor
public enum SettingTypeEnum implements CodeEnum {

    /**
     * 平台名称
     */
    PLATFORM_NAME(0),
    /**
     * 平台logo
     */
    PLATFORM_LOGO(1),
    /**
     * 联系方式
     */
    CONTACT(2),
    /**
     * 微信登录
     */
    WX_LOGIN(3),
    /**
     * 账号注册
     */
    ACCOUNT_REGISTER(4);

    @Getter
    private int code;

}
