package com.cn.mapper.User;

import com.cn.pojo.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;
@MapperScan
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User parameter);

    int insertSelective(User record);

    List<User> selectAll();

    User selectByPrimaryKey(Integer id);

    User selectByName(User record)throws Exception;

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record)throws Exception;
}