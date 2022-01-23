package com.wls.debug.idempotent.moduler;

import com.wls.debug.idempotent.IdempotentApplicationTests;
import com.wls.debug.idempotent.moduler.entity.User;
import com.wls.debug.idempotent.moduler.mapper.UserMapper;
import com.wls.debug.idempotent.moduler.service.UserService;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;

/**
 * @Author:wangpeng
 * @Date: 2022/1/23
 * @Description: ***
 * @version:1.0
 */
public class UserServiceTest extends IdempotentApplicationTests {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
//    @Resource
//    private UserServiceA userServiceA;

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void addTest() {
        User user = new User();
        user.setName("张三");
        user.setIdCard("1000");
        //反例
//        userService.addOk(user);
        //正例
        String key = "key";
        RLock lock = redissonClient.getLock(key);
        lock.lock();
        try {
            userService.addOk(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
