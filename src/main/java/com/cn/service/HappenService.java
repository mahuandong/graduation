package com.cn.service;

import com.cn.pojo.Happen;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/1/20  22:40
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service
 * @version 1.0
 * 类说明：发展情况ervice接口
 */
public interface HappenService {

    int deleteByPrimaryKey(Integer id);

    int insert(Happen record);

    List<Happen> selectAll();

    Happen selectByPrimaryKey(Integer id);

    Happen selectByYear(Integer year);

    Happen selectByArea(String areaCode);

    Map<String, Object> updateByPrimaryKey(Happen record);
}
