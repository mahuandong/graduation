package com.cn.service;

import com.cn.pojo.Index;

import java.util.List;

/**
 * 创建时间：2018/03/05 0:58
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service.Impl
 * @version 1.0
 * 类说明：查询指标接口
 */
public interface IndexService {

    int deleteByPrimaryKey(Integer id);

    int insert(Index record);

    int insertSelective(Index record);

    List<Index> selectByTable(String table);

    Index selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Index record);

    int updateByPrimaryKey(Index record);
}
