package com.cn.mapper.Area;

import com.cn.pojo.Area;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface AreaMapper {

    Area selectByPrimaryKey(String areaCode);

    Area selectByName(String name);

}