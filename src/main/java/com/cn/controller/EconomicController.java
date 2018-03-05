package com.cn.controller;

import com.cn.pojo.Economic;
import com.cn.service.EconomicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * 创建时间：2018/1/21  17:15
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.controller
 * @version 1.0
 * 类说明：经济情况控制类
 */
@Controller
public class EconomicController {
    @Autowired
    private EconomicService economicService;
    //根据id删除
    @RequestMapping(value = { "econDelete.json" }, method = { RequestMethod.POST })
    public @ResponseBody int deleteByPrimaryKey(Integer id) throws Exception{
        return this.economicService.deleteByPrimaryKey(id);
    }
    //添加
    @RequestMapping(value = { "econInsert.json" }, method = { RequestMethod.POST })
    public @ResponseBody int insert(String areaCode,Integer year,Integer gdp,String primary,String second,String third,
                                    String taxRevenue,String disposableIncome,Double gdpRate,Double primaryRate,
                                    Double secondRate,Double thirdRate) throws Exception{
        Economic parameter = new Economic();
        parameter.setAreaCode(areaCode);
        parameter.setYear(year);
        parameter.setGdp(gdp);
        parameter.setPrimary(primary);
        parameter.setSecond(second);
        parameter.setThird(third);
        parameter.setTaxRevenue(taxRevenue);
        parameter.setDisposableIncome(disposableIncome);
        parameter.setGdpRate(gdpRate);
        parameter.setPrimaryRate(primaryRate);
        parameter.setSecondRate(secondRate);
        parameter.setThirdRate(thirdRate);
        return this.economicService.insert(parameter);
    }
    //全查询
    @RequestMapping(value = {"econSelectAll.json"},method = {RequestMethod.GET})
    public @ResponseBody
    List<Economic> selectAll() throws Exception {
        List<Economic> economics = new ArrayList<Economic>();
        economics = this.economicService.selectAll();
        return economics;
    }
    //根据id选择
    @RequestMapping(value = {"econSelectById.json"},method = {RequestMethod.GET})
    public @ResponseBody Economic selectByPrimaryKey(Integer id) throws Exception {
        return this.economicService.selectByPrimaryKey(id);
    }
    //根据年选择
    @RequestMapping(value = {"econSelectByYear.json"},method = {RequestMethod.GET})
    public @ResponseBody Economic selectByYear(Integer year)throws Exception{
        return this.economicService.selectByYear(year);
    }
    //根据地区选择
    @RequestMapping(value = {"econSelectByArea.json"},method = {RequestMethod.GET})
        public @ResponseBody Economic selectByArea(String areaCode) throws Exception {
        return this.economicService.selectByArea(areaCode);
    }
    //更新
    @RequestMapping(value = {"econUpdate.json"},method = {RequestMethod.POST})
    public @ResponseBody
    Object updateByPrimaryKey(String areaCode,Integer year,Integer gdp,String primary,String second,String third,
                              String taxRevenue,String disposableIncome,Double gdpRate,Double primaryRate,
                                  Double secondRate,Double thirdRate)
            throws Exception{
        Economic parameter = new Economic();
        parameter.setAreaCode(areaCode);
        parameter.setYear(year);
        parameter.setGdp(gdp);
        parameter.setPrimary(primary);
        parameter.setSecond(second);
        parameter.setThird(third);
        parameter.setTaxRevenue(taxRevenue);
        parameter.setDisposableIncome(disposableIncome);
        parameter.setGdpRate(gdpRate);
        parameter.setPrimaryRate(primaryRate);
        parameter.setSecondRate(secondRate);
        parameter.setThirdRate(thirdRate);
        Map<String, Object> result = this.economicService.updateByPrimaryKey(parameter);
        return result;
    }
}
