package com.game.model.admin.role.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 修改模块
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("修改模块")
public class UpdateModuleModel {

    @ApiModelProperty("ID")
    @NotNull(message = "ID不能为空")
    private Integer id;

    @ApiModelProperty("模块名称")
    @Length(max = 10, message = "模块名称最多10个字符")
    private String name;

    @ApiModelProperty("路由")
    @Length(max = 50, message = "路由最多50个字符")
    private String url;

    @ApiModelProperty("父节点ID，根节点为0")
    private Integer parentId;

    @ApiModelProperty("权重")
    private Float sort;

    @ApiModelProperty("是否禁用")
    private Boolean disable;
}
