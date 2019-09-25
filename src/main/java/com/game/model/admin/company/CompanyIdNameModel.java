package com.game.model.admin.company;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 企业id名称
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/9/25 22:33
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("企业id名称")
public class CompanyIdNameModel {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;
}
