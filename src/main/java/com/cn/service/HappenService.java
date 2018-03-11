package com.cn.service;

import com.cn.pojo.Happen;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/03/07 19:09
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service
 * @version 1.0
 * 类说明：人口Service接口类
 */
public interface HappenService {

    List<Happen> select();

    List<Happen> selectByAreaYear(Happen record);

    List<Happen> selectById(Integer id);

    Map<String, Object> updateByPrimaryKey(Happen record);

    int deleteByPrimaryKey(Integer id);
}
