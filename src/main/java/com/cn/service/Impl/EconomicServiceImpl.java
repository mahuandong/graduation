package com.cn.service.Impl;

import com.cn.mapper.Economic.EconomicMapper;
import com.cn.pojo.Economic;
import com.cn.service.EconomicService;
import com.cn.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/1/20  21:36
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.service.Impl
 * @version 1.0
 * 类说明：经济情况service实现类
 */

@Service
public class EconomicServiceImpl implements EconomicService {
    @Autowired
    private EconomicMapper economicMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) throws Exception {
        //如果id为空值返回406
        if (StringUtils.isEmpty(id)) {
            System.out.println("id为空");
            return 406;
        }
        int rows = economicMapper.deleteByPrimaryKey(id);
        if (rows > 0) {
            return 1;
        }
        return rows;
    }

    @Override
    public int insert(Economic record) throws Exception {
        String areaCode = record.getAreaCode();
        Integer gdp = record.getGdp();
        String primary = record.getPrimary();
        String second = record.getSecond();
        String third = record.getThird();
        String taxRevenue = record.getTaxRevenue();
        String disposableIncome = record.getDisposableIncome();
        Double gdpRate = record.getGdpRate();
        Double primaryRate = record.getPrimaryRate();
        Double secondRate = record.getSecondRate();
        Double thirdRate = record.getThirdRate();
        Double taxRate = record.getTaxRate();
        Integer year = record.getYear();
        if (areaCode == null && gdp == null && primary == null &&
                second == null && third == null && taxRevenue == null
                && disposableIncome == null) {
            System.out.println("areaCode、gdp、primary、second、third、taxRevenue、disposableIncome至少有一个为空");
            return 406;
        }
        int rows = economicMapper.insert(record);
        return rows;
    }

    @Override
    public List<Economic> selectAll() throws Exception { return this.economicMapper.selectAll(); }

    @Override
    public Economic selectByPrimaryKey(Integer id) throws Exception {
        return this.economicMapper.selectByPrimaryKey(id);
    }

    @Override
    public Economic selectByYear(Integer year) throws Exception {
        return this.economicMapper.selectByYear(year);
    }

    @Override
    public Economic selectByArea(String areaCode) throws Exception {
        return this.economicMapper.selectByArea(areaCode);
    }


    @Override
    public Map<String, Object> updateByPrimaryKey(Economic record) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String areaCode = record.getAreaCode();
        Integer gdp = record.getGdp();
        String primary = record.getPrimary();
        String second = record.getSecond();
        String third = record.getThird();
        String taxRevenue = record.getTaxRevenue();
        String disposableIncome = record.getDisposableIncome();
        Double gdpRate = record.getGdpRate();
        Double primaryRate = record.getPrimaryRate();
        Double secondRate = record.getSecondRate();
        Double thirdRate = record.getThirdRate();
        Double taxRate = record.getTaxRate();
        Integer year = record.getYear();
        if (areaCode == null){
            ResultUtils.paramsError406(result, "areaCode不能为空");
            return result;
        }if (gdp == null && primary == null && second == null && third == null && taxRevenue == null &&
                disposableIncome == null && gdpRate == null && primaryRate == null && secondRate == null
                && thirdRate == null && taxRate == null && year == null) {
            ResultUtils.paramsError406(result, "至少要有1个参数有值");
            return result;
        }
        int rows = this.economicMapper.updateByPrimaryKey(record);
        if (rows == 1) {
            ResultUtils.resultCodeOk(result);
            return result;
        }
        result.put("rows", rows);
        return result;
    }
}
