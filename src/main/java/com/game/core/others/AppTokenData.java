package com.game.core.others;

import com.fanglin.common.core.token.DefaultTokenData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author 彭方林
 * @version 1.0
 * @date 2019/8/28 11:46
 **/
@Setter
@Getter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class AppTokenData extends DefaultTokenData {

    private Integer id;
    /**
     * 手机号
     */
    private String mobile;
}
