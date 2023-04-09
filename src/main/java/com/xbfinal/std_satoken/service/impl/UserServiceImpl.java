package com.xbfinal.std_satoken.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xbfinal.std_satoken.entity.User;
import com.xbfinal.std_satoken.mapper.UserMapper;
import com.xbfinal.std_satoken.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xbfinal
 * @since 2023-04-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getByName(String name) {

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", name);
        User user = baseMapper.selectOne(userQueryWrapper);
        return user;
    }
}
