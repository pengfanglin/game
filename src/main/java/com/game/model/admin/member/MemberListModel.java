package com.game.model.admin.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("会员列表")
public class MemberListModel {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("头像")
    private String headImage;
    @ApiModelProperty("是否禁用")
    private Boolean disable;
    @ApiModelProperty("余额")
    private BigDecimal balance;
    @ApiModelProperty("注册时间")
    private Date createTime;
    @ApiModelProperty("公司名称")
    private String companyName;
}
