package com.cn.controller;

import com.cn.pojo.Area;
import com.cn.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 创建时间：2018/1/20  21:22
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.controller
 * @version 1.0
 * 类说明：Ares控制器
 */
@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = {"area.json"},method = {RequestMethod.GET})
    public @ResponseBody
    Area selectByName(String name)throws Exception{
         return this.areaService.selectByName(name);
    }

    @RequestMapping(value = {"areaName.json"},method = {RequestMethod.GET})
    public @ResponseBody Area selectByPrimaryKey(String areaCode)throws Exception{
        return this.areaService.selectByPrimaryKey(areaCode);
    }
}
