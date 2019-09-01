package com.game.service.common;

import com.game.model.region.RegionTreeModel;

import java.util.List;
import java.util.Map;

/**
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface CommonOthersService {
    /**
     * 发送验证码
     *
     * @param mobile 手机号
     * @param type   类型
     */
    void sendCode(String mobile, String type);

    /**
     * 发送测试验证码
     *
     * @param mobile 手机号
     * @param type   类型
     */
    String sendTestCode(String mobile, String type);

    /**
     * 区域树
     *
     * @return
     */
    List<RegionTreeModel> regionTree();

    /**
     * 区域缓存
     *
     * @return
     */
    Map<Integer, String> regionCache();
}
