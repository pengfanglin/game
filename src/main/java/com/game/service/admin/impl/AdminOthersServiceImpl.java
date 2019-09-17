package com.game.service.admin.impl;

import com.fanglin.common.core.others.Assert;
import com.fanglin.common.util.RegexUtils;
import com.game.enums.others.SettingTypeEnum;
import com.game.mapper.MapperFactory;
import com.game.model.admin.others.SettingListModel;
import com.game.service.admin.AdminOthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 后台其他服务实现类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@Service
public class AdminOthersServiceImpl implements AdminOthersService {

    @Autowired
    MapperFactory mapperFactory;


    @Override
    public void updatePlatformSetting(SettingTypeEnum type, String value) {
        Assert.isTrue(value.length() <= 100, "最大100个字符");
        switch (type) {
            case CONTACT:
                Assert.isTrue(RegexUtils.checkDigit(value), "请输入数字");
                break;
            case WX_LOGIN:
            case ACCOUNT_REGISTER:
                Assert.isTrue(value.equals("true") || value.equals("false"), "只能输入true或者false");
                break;
            default:
        }
        int count = mapperFactory.setting.updatePlatformSetting(type, value);
        Assert.isTrue(count > 0, "修改失败");
    }

    @Override
    public List<SettingListModel> platformSettingList() {
        return mapperFactory.setting.platformSettingList();
    }
}
