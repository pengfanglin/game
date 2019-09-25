package com.game.model.admin.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 增加会员
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("增加会员")
public class AddMemberModel {

    @ApiModelProperty("账号")
    @NotBlank(message = "请填写账号")
    @Length(min = 3, max = 20, message = "账号3-20个字符")
    private String account;

    @ApiModelProperty("密码")
    @NotBlank(message = "请填写密码")
    @Length(max = 20, message = "密码最长20个字符")
    private String password;

    @ApiModelProperty("用户名")
    @NotBlank(message = "请填写用户名")
    @Length(max = 20, message = "用户名最长20个字符")
    private String username;

    @ApiModelProperty("头像")
    @NotBlank(message = "请上传头像")
    @Length(max = 100, message = "头像最长100个字符")
    private String headImage;

    @ApiModelProperty("公司id")
    @NotNull(message = "请选择所属公司")
    private Integer companyId;
}
