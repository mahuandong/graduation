package com.cn.service;

import com.cn.pojo.User;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> selectAll();

    User selectByName(User record)throws Exception;

    int insertSelective(User record)throws Exception;

    int insert(User record) throws ParseException;

    int deleteByPrimaryKey(Integer id)throws Exception;

    Map<String, Object> updateByPrimaryKey(User record)throws Exception;
}
