package com.cn.service.Impl;

import com.cn.mapper.Happen.HappenMapper;
import com.cn.pojo.Happen;
import com.cn.service.HappenService;
import com.cn.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/1/20  23:06
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service.Impl
 * @version 1.0
 * 类说明： 发展情况service实现类
 */
@Service
public class HappenServiceImpl implements HappenService {
    @Autowired
    private HappenMapper happenMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        if (StringUtils.isEmpty(id)) {
            System.out.println("id为空");
            return 406;
        }
        int rows = happenMapper.deleteByPrimaryKey(id);
        if (rows > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int insert(Happen record) {
        String areaCode = record.getAreaCode();
        Integer population = record.getPopulation();
        Integer laborForce = record.getLaborForce();
        String primary = record.getPrimary();
        String second = record.getSecond();
        String third  = record.getThird();
        Integer year = record.getYear();
        if (areaCode == null && population == null && year == null) {
            System.out.println("areaCode、population、year至少有一个为空");
            return 406;
        }
        int rows = happenMapper.insert(record);
        return rows;
    }

    @Override
    public List<Happen> selectAll() { return this.happenMapper.selectAll(); }

    @Override
    public Happen selectByPrimaryKey(Integer id) { return this.happenMapper.selectByPrimaryKey(id); }

    @Override
    public Happen selectByYear(Integer year) {
        return this.happenMapper.selectByYear(year);
    }

    @Override
    public Happen selectByArea(String areaCode) { return this.happenMapper.selectByArea(areaCode); }

    @Override
    public Map<String, Object> updateByPrimaryKey(Happen record) {
        Map<String, Object> result = new HashMap<String, Object>();
        String areaCode = record.getAreaCode();
        Integer population = record.getPopulation();
        Integer laborForce = record.getLaborForce();
        String primary = record.getPrimary();
        String second = record.getSecond();
        String third  = record.getThird();
        Integer year = record.getYear();
        if (areaCode == null){
            ResultUtils.paramsError406(result,"areaCode不能为空");
        }if (population == null && laborForce == null && primary == null && second == null && third == null && year == null) {
            ResultUtils.paramsError406(result, "至少要有1个参数有值");
            return result;
        }
        int rows = happenMapper.updateByPrimaryKey(record);
        if (rows == 1) {
            ResultUtils.resultCodeOk(result);
            return result;
        }
        result.put("rows", rows);
        return result;
    }
}
