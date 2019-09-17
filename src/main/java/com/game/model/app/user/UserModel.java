package com.game.model.app.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 用户信息
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 13:06
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("用户信息")
public class UserModel {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("密码盐值")
    private String salt;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("是否禁用")
    private Boolean disable;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("修改时间")
    private Date updateTime;
}
