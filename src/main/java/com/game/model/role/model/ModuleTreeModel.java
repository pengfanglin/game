package com.game.model.role.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统模块树
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:43
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("系统模块树")
public class ModuleTreeModel implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("模块名称")
    private String name;

    @ApiModelProperty("模块访问路径")
    private String url;

    @ApiModelProperty("父节点id")
    private Integer parentId;

    @ApiModelProperty("权重")
    private Float sort;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("子模块")
    private List<ModuleTreeModel> children;
}
