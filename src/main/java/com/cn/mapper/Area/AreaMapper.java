package com.cn.mapper.Area;

import com.cn.pojo.Area;

import java.util.List;

public interface AreaMapper {

    List<Area> selectAll();

    List<Area> selectByLevel(Integer level);
}
