package com.game.model.admin.others;

import com.game.enums.others.SettingTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 平台设置列表
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:40
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel("平台设置列表")
public class SettingListModel {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("值")
    private String value;
    @ApiModelProperty("PLATFORM_NAME-平台名称 PLATFORM_LOGO-平台logo CONTACT-联系方式")
    private SettingTypeEnum type;
    @ApiModelProperty("创建时间")
    private Date createTime;
}
