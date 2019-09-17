package com.game.model.app.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 用户登录返回对象
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 13:06
 **/
@Setter
@Getter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户登录返回对象")
public class MemberLoginResultModel {
    @ApiModelProperty("鉴权token")
    private String accessToken;
    @ApiModelProperty("刷新token")
    private String refreshToken;
}
