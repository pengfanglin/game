package com.game.model.admin.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员列表搜索
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("会员列表搜索")
public class MemberListSearch {
    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("是否禁用")
    private Boolean disable;
}
