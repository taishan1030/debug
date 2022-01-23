package com.wls.debug.idempotent.moduler.service;

import com.wls.debug.idempotent.moduler.entity.User;

/**
 * @Author:wangpeng
 * @Date: 2022/1/23
 * @Description: ***
 * @version:1.0
 */
public interface UserService {
    void addError(User user);

    void addOk(User user);
}
