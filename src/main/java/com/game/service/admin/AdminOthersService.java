package com.game.service.admin;


import com.game.enums.others.SettingTypeEnum;
import com.game.model.admin.others.SettingListModel;

import java.util.List;

/**
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface AdminOthersService {

    /**
     * 修改系统设置
     *
     * @param type
     * @param value
     */
    void updatePlatformSetting(SettingTypeEnum type, String value);

    /**
     * 平台设置列表
     *
     * @return
     */
    List<SettingListModel> platformSettingList();
}
