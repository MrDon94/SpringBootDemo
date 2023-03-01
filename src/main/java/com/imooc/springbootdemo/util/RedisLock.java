package com.imooc.springbootdemo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 自己实现的分布式锁
 * 扩展两种分布式锁的实现方式：一种是 Redis + Lua；另一种是 Redission(官方推荐)。
 */
@Slf4j
@Component
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean lock(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public boolean lockV2(String key, String value,Long timeOut) {
        return redisTemplate.opsForValue().setIfAbsent(key, value,timeOut, TimeUnit.MILLISECONDS);
    }

    public boolean lockV3(String key, String value) {
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }

        String oldValue = redisTemplate.opsForValue().get(key);

        if (Objects.nonNull(oldValue) && System.currentTimeMillis() > Long.parseLong(oldValue)) {
            String valueByGetAndSet = redisTemplate.opsForValue().getAndSet(key, value);
            if (Objects.isNull(valueByGetAndSet) || valueByGetAndSet.equals(oldValue)) {
                return true;
            }
        }

        return false;
    }

    public void unLock(String key) {
        redisTemplate.delete(key);
    }

    public void unLockV2(String key, String value) {
        String oldValue = redisTemplate.opsForValue().get(key);
        if (Objects.nonNull(oldValue) && oldValue.equals(value)) {
            try {
                redisTemplate.delete(key);
            } catch (Exception e) {
                log.error("解锁失败：{}",e);
            }
        }
    }
}
