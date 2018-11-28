package org.sopt.seminar.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by ds on 2018-11-27.
 */

@Slf4j
@Service
public class TestService {

    private final RedisTemplate redisTemplate;

    public TestService(final RedisTemplate redisTemplate) {
        log.info("testService");
        this.redisTemplate = redisTemplate;
    }

}
