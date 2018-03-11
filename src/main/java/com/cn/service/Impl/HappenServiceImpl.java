package com.cn.service.Impl;

import com.cn.mapper.Happen.HappenMapper;
import com.cn.pojo.Happen;
import com.cn.service.HappenService;
import com.cn.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/03/07 19:10
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service.Impl
 * @version 1.0
 * 类说明：人口Service实现类
 */
@Service
public class HappenServiceImpl implements HappenService{

    @Autowired
    private HappenMapper happenMapper;

    @Override
    public List<Happen> select() {
        return this.happenMapper.select();
    }

    @Override
    public List<Happen> selectByAreaYear(Happen record) {
        return this.happenMapper.selectByAreaYear(record);
    }

    @Override
    public List<Happen> selectById(Integer id) { return this.happenMapper.selectById(id); }

    @Override
    public Map<String, Object> updateByPrimaryKey(Happen record) {
        Map<String, Object> result = new HashMap<String, Object>();
        Integer id = record.getId();
        Integer areaCode = record.getAreaCode();
        Integer year = record.getYear();
        Integer population = record.getPopulation();
        Float birth = record.getBirth();
        Float death = record.getDeath();
        Float growth = record.getGrowth();
        if (areaCode == null){
            ResultUtils.paramsError406(result, "areaCode不能为空");
            return result;
        }if (population == null && birth == null && death == null && growth == null && year == null) {
            ResultUtils.paramsError406(result, "至少要有1个参数有值");
            return result;
        }
        int rows = this.happenMapper.updateByPrimaryKey(record);
        if (rows == 1) {
            ResultUtils.resultCodeOk(result);
            return result;
        }
        result.put("rows", rows);
        return result;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.happenMapper.deleteByPrimaryKey(id);
    }

}
