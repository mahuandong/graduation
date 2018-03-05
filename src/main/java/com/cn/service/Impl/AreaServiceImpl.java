package com.cn.service.Impl;

import com.cn.mapper.Area.AreaMapper;
import com.cn.pojo.Area;
import com.cn.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间：2018/03/05 0:29
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service.Impl
 * @version 1.0
 * 类说明：地区实现类
 */
@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public List<Area> selectAll() {
        return this.areaMapper.selectAll();
    }

    @Override
    public List<Area> selectByLevel(Integer level) {
        return this.areaMapper.selectByLevel(level);
    }
}
