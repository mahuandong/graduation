package com.cn.controller;

import com.cn.pojo.Area;
import com.cn.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间：2018/03/05 0:31
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.controller
 * @version 1.0
 * 类说明：地区控制类
 */
@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;

    //全查询
    @RequestMapping(value = {"area.json"},method = {RequestMethod.GET})
    public @ResponseBody
    List<Area> selectAll() throws Exception {
        return this.areaService.selectAll();
    }
    //全查询
    @RequestMapping(value = {"areaByLevel.json"},method = {RequestMethod.GET})
    public @ResponseBody
    List<Area> selectByLevel(Integer level) throws Exception {
        return this.areaService.selectByLevel(level);
    }

}
