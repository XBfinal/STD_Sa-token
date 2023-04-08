package com.xbfinal.std_satoken.service;

import com.xbfinal.std_satoken.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xbfinal
 * @since 2023-04-08
 */
public interface UserService extends IService<User> {
    public User getByName(String name);
}
