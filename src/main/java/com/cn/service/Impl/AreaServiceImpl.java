package com.cn.service.Impl;

import com.cn.mapper.Area.AreaMapper;
import com.cn.pojo.Area;
import com.cn.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建时间：2018/1/20  21:13
 * 项目名称：SpringMVC
 *
 * @author mahua
 * Package com.cn.service.Impl
 * @version 1.0
 * 类说明：Area业务层实现类
 */
@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public Area selectByPrimaryKey(String areaCode) throws Exception {
        return this.areaMapper.selectByPrimaryKey(areaCode);
    }

    @Override
    public Area selectByName(String name) throws Exception {
        return this.areaMapper.selectByName(name);
    }
}
