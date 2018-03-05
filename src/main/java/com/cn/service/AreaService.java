package com.cn.service;

import com.cn.pojo.Area;

import java.util.List;

/**
 * 创建时间：2018/3/5  21:29
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service
 * @version 1.0
 * 类说明：地区Service接口
 */
public interface AreaService {

    List<Area> selectAll();

    List<Area> selectByLevel(Integer level);
}
