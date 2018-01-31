package com.cn.service;

import com.cn.pojo.Economic;
import com.cn.pojo.Monthly;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/1/20  23:59
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service.Impl
 * @version 1.0
 * 类说明：每月GDP Service接口
 */
public interface MonthlyService {

    int deleteByPrimaryKey(Integer id);

    int insert(Monthly record);

    List<Monthly> selectAll();

    Monthly selectByPrimaryKey(Integer id);

    Monthly selectByYear(Integer year);

    Map<String, Object> updateByPrimaryKeySelective(Monthly record);

}
