package com.cn.mapper.Happen;

import com.cn.pojo.Happen;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface HappenMapper {
    int deleteByPrimaryKey(Integer areaCode);

    int insert(Happen record);

    int insertSelective(Happen record);

    List<Happen> selectAll();

    Happen selectByPrimaryKey(Integer id);

    Happen selectByYear(Integer year);

    Happen selectByArea(String areaCode);

    int updateByPrimaryKeySelective(Happen record);

    int updateByPrimaryKey(Happen record);
}