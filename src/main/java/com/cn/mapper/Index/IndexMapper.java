package com.cn.mapper.Index;

import com.cn.pojo.Index;

import java.util.List;

public interface IndexMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Index record);

    int insertSelective(Index record);

    List<Index> selectByTable(String table);

    Index selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Index record);

    int updateByPrimaryKey(Index record);
}