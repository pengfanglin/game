package com.game.model.admin.company;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 公司列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("公司列表")
public class CompanyListModel {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("注册时间")
    private Date createTime;
    @ApiModelProperty("余额")
    private BigDecimal balance;
}
