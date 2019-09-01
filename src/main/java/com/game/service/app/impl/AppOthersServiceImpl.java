package com.game.service.app.impl;

import com.game.mapper.MapperFactory;
import com.game.service.app.AppOthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 其他服务实现类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@Service
public class AppOthersServiceImpl implements AppOthersService {

    @Autowired
    MapperFactory mapperFactory;

}
