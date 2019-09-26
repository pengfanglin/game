package com.game.model.admin.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 修改会员
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("修改会员")
public class UpdateMemberModel {

    @ApiModelProperty(value = "账号id", required = true)
    @NotNull(message = "账号id不能为空")
    private Integer id;

    @ApiModelProperty(value = "账号")
    @Length(min = 3, max = 20, message = "账号3-20个字符")
    private String account;

    @ApiModelProperty(value = "密码")
    @Length(max = 20, message = "密码最长20个字符")
    private String password;

    @ApiModelProperty(value = "用户名")
    @Length(max = 20, message = "用户名最长20个字符")
    private String username;

    @ApiModelProperty("手机号")
    @Length(max = 11, message = "手机号最长11个字符")
    private String mobile;

    @ApiModelProperty(value = "头像")
    @Length(max = 100, message = "头像最长100个字符")
    private String headImage;
}
