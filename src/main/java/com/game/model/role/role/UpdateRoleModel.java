package com.game.model.role.role;

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
 * 修改角色
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("修改角色")
public class UpdateRoleModel {

    @ApiModelProperty("ID")
    @NotNull(message = "ID不能为空")
    private Integer id;

    @ApiModelProperty("角色名称")
    @Length(max = 20, message = "角色名称最多20个字符")
    private String name;

    @ApiModelProperty("模块")
    @Length(max = 500, message = "模块最多50个字符")
    private String moduleIds;

    @ApiModelProperty("权重")
    private Float sort;

    @ApiModelProperty("是否禁用")
    private Boolean disable;
}
