package com.game.model.admin.company;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 添加公司
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("添加公司")
public class AddCompanyModel {
    @ApiModelProperty("账号")
    @NotBlank(message = "账号不能为空")
    @Length(max = 20, message = "账号最多20个字符")
    private String account;

    @ApiModelProperty("名称")
    @NotBlank(message = "名称不能为空")
    @Length(max = 20, message = "名称最多20个字符")
    private String name;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    @Length(max = 20, message = "密码最多20个字符")
    private String password;

    @ApiModelProperty("联系方式")
    @NotNull(message = "联系方式不能为空")
    private Long mobile;

    @ApiModelProperty("到期时间")
    private Date expireTime;

    @ApiModelProperty("是否禁用")
    private Boolean disable;
}
