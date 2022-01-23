package com.wls.debug.idempotent.moduler.controller;

import com.wls.debug.idempotent.moduler.entity.User;
import com.wls.debug.idempotent.moduler.service.UserService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:wangpeng
 * @Date: 2022/1/23
 * @Description: ***
 * @version:1.0
 */
@RestController

public class UserController {

    @Resource
    RedissonClient redissonClient;
    @Resource
    UserService userService;

    @RequestMapping("/add")
    public void addUser(String idCard) {
        User user = new User();
        user.setName("张三" + idCard);
        user.setIdCard(idCard);
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
