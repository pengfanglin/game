package com.game.model.admin.role.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 系统模块列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:43
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel(value = "系统模块列表")
public class ModuleListModel {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "模块名称")
    private String name;

    @ApiModelProperty(value = "模块访问路径")
    private String url;

    @ApiModelProperty(value = "父节点id")
    private Integer parentId;

    @ApiModelProperty(value = "权重")
    private Float sort;

    @ApiModelProperty(value = "是否禁用")
    private Boolean disable;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
