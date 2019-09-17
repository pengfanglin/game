package com.game.model.admin.role.account;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 添加账号
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("添加账号")
public class AddAccountModel {
    @ApiModelProperty("账号")
    @NotBlank(message = "账号不能为空")
    @Length(max = 20, message = "账号最多20个字符")
    private String account;

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名最多20个字符")
    private String username;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    @Length(max = 20, message = "密码最多20个字符")
    private String password;

    @ApiModelProperty("头像")
    @NotBlank(message = "头像不能为空")
    @Length(max = 100, message = "头像最多100个字符")
    private String headImage;

    @ApiModelProperty("角色id组合")
    @NotBlank(message = "角色不能为空")
    @Length(max = 500, message = "角色不能为空最多500个字符")
    private String roleIds;
}
