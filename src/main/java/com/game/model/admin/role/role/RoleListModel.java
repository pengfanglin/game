package com.game.model.admin.role.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 角色列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:38
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("角色列表")
public class RoleListModel {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("禁用")
    private Boolean disable;

    @ApiModelProperty("权重")
    private Float sort;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("角色拥有的模块组合")
    private String moduleIds;
}
