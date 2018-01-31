package com.cn.controller;

import com.cn.pojo.Happen;
import com.cn.service.HappenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/1/21  18:07
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.controller
 * @version 1.0
 * 类说明：发展情况控制类
 */
@Controller
public class HappenController {
    @Autowired
    private HappenService happenService;
    //根据id删除
    @RequestMapping(value = { "happenDelete.json" }, method = { RequestMethod.POST })
    public @ResponseBody int deleteByPrimaryKey(Integer id) { return this.happenService.deleteByPrimaryKey(id); }

    //添加
    @RequestMapping(value = { "happenInsert.json" }, method = { RequestMethod.POST })
    public @ResponseBody int insert(String areaCode,Integer population,Integer laborForce,
                                    String primary,String second,String third,Integer year)
            throws Exception{
        Happen parameter = new Happen();
        parameter.setAreaCode(areaCode);
        parameter.setPopulation(population);
        parameter.setLaborForce(laborForce);
        parameter.setPrimary(primary);
        parameter.setSecond(second);
        parameter.setThird(third);
        parameter.setYear(year);
        return this.happenService.insert(parameter);
    }
    //
    @RequestMapping(value = { "happenSelectAll.json" }, method = { RequestMethod.GET })
    public @ResponseBody
    List<Happen> selectAll(Integer id) { return this.happenService.selectAll(); }
    //根据id选择
    @RequestMapping(value = { "happenSelectById.json" }, method = { RequestMethod.GET })
    public @ResponseBody Happen selectByPrimaryKey(Integer id) { return this.happenService.selectByPrimaryKey(id); }

    //根据年份选择
    @RequestMapping(value = { "happenSelectByYear.json" }, method = { RequestMethod.GET })
    public @ResponseBody Happen selectByYear(Integer year) { return this.happenService.selectByYear(year); }

    //根据地区选择
    @RequestMapping(value = { "happenSelectByArea.json" }, method = { RequestMethod.GET })
    public @ResponseBody Happen selectByArea(String areaCode) { return this.happenService.selectByArea(areaCode); }

    @RequestMapping(value = {"happenUpdate.json"},method = {RequestMethod.POST})
    public @ResponseBody Object updateByPrimaryKey(Integer id, String areaCode,Integer population,Integer laborForce,
                                                       String primary,String second,String third,Integer year) {
        Happen parameter = new Happen();
        parameter.setId(id);
        parameter.setAreaCode(areaCode);
        parameter.setPopulation(population);
        parameter.setLaborForce(laborForce);
        parameter.setPrimary(primary);
        parameter.setSecond(second);
        parameter.setThird(third);
        parameter.setYear(year);
        Map<String, Object> result = this.happenService.updateByPrimaryKey(parameter);
        return result;
    }
}
