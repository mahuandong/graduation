package com.cn.controller;

import com.cn.pojo.Happen;
import com.cn.service.HappenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

/**
 * 创建时间：2018/03/07 19:12
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.controller
 * @version 1.0
 * 类说明：人口controller类
 */
@Controller
public class HappenController {
    @Autowired
    private HappenService happenService;
    //全查询
    @RequestMapping(value = {"happenAll.json"},method = {RequestMethod.GET})
    public @ResponseBody
    List<Happen> select()throws Exception{
        return this.happenService.select();
    }
    //根据id查询
    @RequestMapping(value = {"happenById.json"},method = {RequestMethod.GET})
    public @ResponseBody
    List<Happen> selectById(Integer id)throws Exception{ return this.happenService.selectById(id); }
    //根据地区与时间查询
    @RequestMapping(value = {"happenSelect.json"},method = {RequestMethod.GET})
    public @ResponseBody
    List<Happen> selectByAreaYear(Integer areaCode, Integer year)throws Exception{
        Happen parameter = new Happen();
        parameter.setAreaCode(areaCode);
        parameter.setYear(year);
        return this.happenService.selectByAreaYear(parameter);
    }
    //根据id更新
    @RequestMapping(value = {"happenUpdate.json"},method = {RequestMethod.POST})
    public @ResponseBody
    Object  updateByPrimaryKey(Integer id, Integer areaCode, Integer population ,Integer year ,Float birth ,Float death ,Float growth)throws Exception{
        Happen parameter = new Happen();
        parameter.setId(id);
        parameter.setAreaCode(areaCode);
        parameter.setPopulation(population);
        parameter.setYear(year);
        parameter.setBirth(birth);
        parameter.setDeath(death);
        parameter.setGrowth(growth);
        Map<String, Object> result = this.happenService.updateByPrimaryKey(parameter);
        return result;
    }
    //根据id删除
    @RequestMapping(value = {"happenDelete.json"},method = {RequestMethod.GET})
    public @ResponseBody
    Integer deleteByPrimaryKey(Integer id)throws Exception{ return this.happenService.deleteByPrimaryKey(id); }
}
