package com.game.enums.member;

import com.fanglin.common.core.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 会员流水类型
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/16 20:27
 **/
@AllArgsConstructor
public enum MemberFlowWaterTypeEnum implements CodeEnum {

    /**
     * 找回密码
     */
    ADMIN_TOP_UP(0),
    /**
     * 修改密码
     */
    MEMBER_TOP_UP(1);

    @Getter
    private int code;
}
