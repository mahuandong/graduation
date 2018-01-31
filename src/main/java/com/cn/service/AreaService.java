package com.cn.service;

import com.cn.pojo.Area;

/**
 * 创建时间：2018/1/20  21:12
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service
 * @version 1.0
 * 类说明：地区service接口
 */
public interface AreaService {

    Area selectByPrimaryKey(String areaCode) throws Exception;

    Area selectByName(String name)throws Exception;
}
