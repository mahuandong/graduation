package com.cn.mapper.Monthly;

import com.cn.pojo.Monthly;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface MonthlyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Monthly record);

    int insertSelective(Monthly record);

    List<Monthly> selectAll();

    Monthly selectByPrimaryKey(Integer id);

    Monthly selectByYear(Integer year);

    int updateByPrimaryKeySelective(Monthly record);

    int updateByPrimaryKey(Monthly record);
}