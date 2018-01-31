package com.cn.service;

import com.cn.pojo.Economic;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/1/20  21:29
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service
 * @version 1.0
 * 类说明：经济情况Service接口
 */
public interface EconomicService {
    int deleteByPrimaryKey(Integer id)throws Exception;

    int insert(Economic record)throws Exception;

    List<Economic> selectAll()throws Exception;

    Economic selectByPrimaryKey(Integer id)throws Exception;

    Economic selectByYear(Integer year)throws Exception;

    Economic selectByArea(String areaCode)throws Exception;

    Map<String, Object> updateByPrimaryKey(Economic record)throws Exception;
}
