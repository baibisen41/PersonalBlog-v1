package com.bbs.personalblog.utils;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by 大森 on 2017/12/2.
 */
public class JedisUtil {

    //待学习jedispool后重构
    private static Jedis jedis;

    public static Jedis getJedis(JedisPool jedisPool) {

        if (jedis == null) {
            jedis = jedisPool.getResource();

        }
        return jedis;
    }

    public static void close() {
        jedis.close();
    }

}
