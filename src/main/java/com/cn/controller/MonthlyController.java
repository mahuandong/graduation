package com.cn.controller;

import com.cn.pojo.Monthly;
import com.cn.service.MonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/1/21  18:34
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.controller
 * @version 1.0
 * 类说明：每月情况控制类
 */
@Controller
public class MonthlyController {
    @Autowired
    private MonthlyService monthlyService;

    //根据id删除
    @RequestMapping(value = { "monthlyDelete.json" }, method = { RequestMethod.POST })
    public @ResponseBody int deleteByPrimaryKey(Integer id) { return this.monthlyService.deleteByPrimaryKey(id); }

    //添加
    @RequestMapping(value = { "monthlyInsert.json" }, method = { RequestMethod.POST })
    public @ResponseBody int insert(Integer year,String areaCode,Float one,Float feb,Float three,Float four){
        Monthly parameter = new Monthly();
        parameter.setYear(year);
        parameter.setAreaCode(areaCode);
        parameter.setOne(one);
        parameter.setFeb(feb);
        parameter.setThree(three);
        parameter.setFour(four);
        return this.monthlyService.insert(parameter);
    }
    //全选
    @RequestMapping(value = { "monthlySelectAll.json" }, method = { RequestMethod.GET })
    public @ResponseBody List<Monthly> selectAll(){return this.monthlyService.selectAll();}
    //根据地区选择
    @RequestMapping(value = { "monthlySelectByArea.json" }, method = { RequestMethod.GET })
    public @ResponseBody List<Monthly> selectByArea(String areaCode,Integer year){
        Monthly parameter = new Monthly();
        parameter.setYear(year);
        parameter.setAreaCode(areaCode);
        return this.monthlyService.selectByArea(parameter);
    }

    //根据id选择
    @RequestMapping(value = { "monthlySelectById.json" }, method = { RequestMethod.GET })
    public @ResponseBody Monthly selectById(Integer id) { return this.monthlyService.selectById(id); }

    //根据年选择
    @RequestMapping(value = { "monthlySelectByYear.json" }, method = { RequestMethod.GET })
    public @ResponseBody Monthly selectByYear(Integer year) { return this.monthlyService.selectByYear(year); }
    //修改
    @RequestMapping(value = { "monthlyUpdate.json" }, method = { RequestMethod.POST })
    public @ResponseBody
    Object updateByPrimaryKeySelective(Integer year,String areaCode,Float one,Float feb,Float three,Float four){
        Monthly parameter = new Monthly();
        parameter.setYear(year);
        parameter.setAreaCode(areaCode);
        parameter.setOne(one);
        parameter.setFeb(feb);
        parameter.setThree(three);
        parameter.setFour(four);
        Map<String ,Object> result = this.monthlyService.updateByPrimaryKeySelective(parameter);
        return result;
    }
}
