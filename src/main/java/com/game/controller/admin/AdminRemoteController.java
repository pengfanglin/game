package com.game.controller.admin;

import com.fanglin.common.core.aop.LocalCacheAop;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.util.JedisUtils;
import com.fanglin.common.util.JvmUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

/**
 * 远程控制
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@RestController
@RequestMapping("/admin/remote/")
@Api(value = "/admin/remote", tags = {"后台-远程控制"})
public class AdminRemoteController {

    @Autowired
    JedisPool jedisPool;

    @ApiOperation("查看redis连接信息")
    @PostMapping("redisInfo")
    public Ajax redisInfo() {
        Map<String, Object> info = new HashMap<>(4);
        info.put("active", jedisPool.getNumActive());
        info.put("idle", jedisPool.getNumIdle());
        info.put("wait", jedisPool.getNumWaiters());
        return Ajax.ok(info);
    }

    @ApiOperation("删除redis")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "keys", value = "key,逗号分隔", required = true),
    })
    @PostMapping("deleteRedis")
    public Ajax deleteRedisKey(@RequestParam String keys) {
        try (Jedis jedis = JedisUtils.getJedis()) {
            jedis.del(keys.split(","));
        }
        return Ajax.ok();
    }

    @ApiOperation("删除本地缓存")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "keys", value = "key,逗号分隔", required = true)
    })
    @PostMapping("deleteLocalCache")
    public Ajax deleteLocalCache(@RequestParam String keys) {
        for (String key : keys.split(",")) {
            LocalCacheAop.getCache().remove(key);
        }
        return Ajax.ok();
    }

    @ApiOperation("清空本地缓存")
    @PostMapping("clearLocalCache")
    public Ajax clearLocalCache() {
        LocalCacheAop.getCache().clear();
        return Ajax.ok();
    }

    @ApiOperation("本地缓存状态")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "showValue", value = "是否查看缓存的值", defaultValue = "false")
    })
    @PostMapping("localCacheInfo")
    public Ajax<LocalCacheAop.CacheInfo> localCacheInfo(Boolean showValue) {
        return Ajax.ok(LocalCacheAop.cacheInfo(showValue));
    }

    @ApiOperation("jvm状态")
    @PostMapping("jvmState")
    public Ajax<JvmUtils.JvmInfo> jvmState() {
        return Ajax.ok(JvmUtils.jvmInfo());
    }
}
