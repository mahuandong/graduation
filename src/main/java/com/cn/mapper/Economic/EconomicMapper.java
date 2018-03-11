package com.cn.mapper.Economic;

import com.cn.pojo.Economic;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface EconomicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Economic record);

    int insertSelective(Economic record);

    List<Economic> selectAll();

    Economic selectByPrimaryKey(Integer id);

    Economic selectByYear(Integer year);

    List<Economic> selectByArea(String areaCode);

    int updateByPrimaryKeySelective(Economic record);

    int updateByPrimaryKey(Economic record);
}