package com.cn.service.Impl;

import com.cn.mapper.Index.IndexMapper;
import com.cn.pojo.Index;
import com.cn.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间：2018/03/05 0:59
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service.Impl
 * @version 1.0
 * 类说明：查询指标实现类
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Index record) {
        return 0;
    }

    @Override
    public int insertSelective(Index record) {
        return 0;
    }

    @Override
    public List<Index> selectByTable(String table) {
        return this.indexMapper.selectByTable(table);
    }

    @Override
    public Index selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Index record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Index record) {
        return 0;
    }
}
