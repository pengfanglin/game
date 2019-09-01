package com.game.model.role.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 添加模块
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("添加模块")
public class AddModuleModel {
    @ApiModelProperty("模块名称")
    @NotBlank(message = "模块名称不能为空")
    @Length(max = 10, message = "模块名称最多10个字符")
    private String name;

    @ApiModelProperty("路由")
    @NotBlank(message = "路由不能为空")
    @Length(max = 50, message = "路由最多50个字符")
    private String url;

    @ApiModelProperty("父节点ID，根节点为0")
    @NotNull(message = "父节点ID不能为空")
    private Integer parentId;

    @ApiModelProperty("权重")
    private Float sort;
}
