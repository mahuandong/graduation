package com.cn.mapper.Happen;

import com.cn.pojo.Happen;

import java.util.List;

public interface HappenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Happen record);

    int insertSelective(Happen record);

    List<Happen> select();

    List<Happen> selectById(Integer id);

    List<Happen> selectByAreaYear(Happen record);

    int updateByPrimaryKeySelective(Happen record);

    int updateByPrimaryKey(Happen record);
}