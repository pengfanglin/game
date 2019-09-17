package com.game.service.common.impl;

import com.fanglin.common.annotation.LocalCache;
import com.fanglin.common.util.JedisUtils;
import com.fanglin.common.util.OthersUtils;
import com.fanglin.common.util.SmsUtils;
import com.game.enums.others.RedisKeyEnum;
import com.game.enums.others.SettingTypeEnum;
import com.game.mapper.MapperFactory;
import com.game.model.common.region.RegionTreeModel;
import com.game.service.common.CommonOthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * 其他服务实现类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@Service
public class CommonOthersServiceImpl implements CommonOthersService {

    @Autowired
    MapperFactory mapperFactory;

    @Override
    public void sendCode(String mobile, String type) {
        String code = OthersUtils.randomString(4);
        String key = String.format("%s:%s:%s:%s", RedisKeyEnum.CODE.getKey(), type, mobile, code);
        String params = String.format("{\"code\":\"%s\"}", code);
        SmsUtils.aliCode(mobile, "趣兼职", type, params);
        try (Jedis jedis = JedisUtils.getJedis()) {
            jedis.set(key, "", "ex", 600);
        }
    }

    @Override
    public String sendTestCode(String mobile, String type) {
        String code = OthersUtils.randomString(4);
        String key = String.format("%s:%s:%s:%s", RedisKeyEnum.CODE.getKey(), type, mobile, code);
        try (Jedis jedis = JedisUtils.getJedis()) {
            jedis.set(key, "", "ex", 600);
        }
        return code;
    }

    @Override
    @LocalCache(value = "'regionTree'", timeout = 1, unit = TimeUnit.DAYS)
    public List<RegionTreeModel> regionTree() {
        return mapperFactory.region.regionTree();
    }

    @Override
    @LocalCache(value = "'regionCache'", timeout = 1, unit = TimeUnit.DAYS)
    public Map<Integer, String> regionCache() {
        List<Map<String, Object>> data = mapperFactory.region.regionCache();
        Map<Integer, String> cache = new HashMap<>(data.size());
        data.forEach(item -> {
            cache.put(Integer.valueOf(item.get("code").toString()), item.get("name").toString());
        });
        return cache;
    }

    @Override
    public String getPlatformSetting(SettingTypeEnum type) {
        return mapperFactory.setting.getPlatformSetting(type);
    }
}
