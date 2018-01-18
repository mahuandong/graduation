package com.cn.service;

import com.cn.pojo.User;

public interface UserService {
    User selectByPrimaryKey(Integer id) throws Exception;
}
