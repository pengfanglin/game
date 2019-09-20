package com.game.core.others;

import com.fanglin.common.core.token.DefaultTokenData;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 管理端账号数据
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 11:46
 **/
@Setter
@Getter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class AdminTokenData extends DefaultTokenData {
    @ApiModelProperty(hidden = true)
    private Integer id;
}
