package com.cn.service.Impl;

import com.cn.mapper.Monthly.MonthlyMapper;
import com.cn.pojo.Monthly;
import com.cn.service.MonthlyService;
import com.cn.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/1/21  0:07
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service.Impl
 * @version 1.0
 * 类说明：每月GDP Service实现类
 */
@Service
public class MonthlyServiceImpl implements MonthlyService{
    @Autowired
    private MonthlyMapper monthlyMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.monthlyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Monthly record) {
        Integer year = record.getYear();
        String areaCode = record.getAreaCode();
        Float one = record.getOne();
        Float feb = record.getFeb();
        Float three = record.getThree();
        Float four = record.getFour();
        if (year == null && areaCode == null) {
            System.out.println("name、account、password至少有一个为空");
            return 406;
        }
        int rows = monthlyMapper.insert(record);
        return rows;
    }

    @Override
    public List<Monthly> selectAll() {
        return this.monthlyMapper.selectAll();
    }

    @Override
    public Monthly selectById(Integer id) {
        return this.monthlyMapper.selectById(id);
    }

    @Override
    public List<Monthly> selectByArea(Monthly record) { return this.monthlyMapper.selectByArea(record); }

    @Override
    public Monthly selectByYear(Integer year) {
        return this.monthlyMapper.selectByYear(year);
    }

    @Override
    public Map<String, Object> updateByPrimaryKeySelective(Monthly record) {
        Map<String, Object> result = new HashMap<String, Object>();
        Integer id =record.getId();
        Integer year = record.getYear();
        String areaCode = record.getAreaCode();
        Float one = record.getOne();
        Float feb = record.getFeb();
        Float three = record.getThree();
        Float four = record.getFour();
        if (id == null){
            ResultUtils.paramsError406(result, "id不能为空");
            return result;
        }
        if (year == null && areaCode == null && one == null && feb == null && three == null && four == null) {
            ResultUtils.paramsError406(result, "至少要有1个参数有值");
            return result;
        }
        int rows = monthlyMapper.updateByPrimaryKey(record);
        if (rows == 1) {
            ResultUtils.resultCodeOk(result);
            return result;
        }
        result.put("rows", rows);
        return result;
    }
}
