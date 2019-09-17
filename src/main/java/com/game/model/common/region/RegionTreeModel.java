package com.game.model.common.region;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 区域树
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/30 21:20
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel("区域树")
public class RegionTreeModel {
    @ApiModelProperty("区域编码")
    private Integer code;
    @ApiModelProperty("父区域编码")
    private Integer parentCode;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("子区域")
    private List<RegionTreeModel> children;
}
