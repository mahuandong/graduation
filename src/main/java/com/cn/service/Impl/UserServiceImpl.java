package com.cn.service.Impl;

import com.cn.mapper.UserMapper;
import com.cn.pojo.User;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByPrimaryKey(Integer id) throws Exception {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
