package com.cn.controller;

import com.cn.pojo.Items;
import com.cn.service.ItemsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
@Controller
public class ItemsController {
    @Resource
    private ItemsService itemsService;

        @RequestMapping("/queryItems")
    public ModelAndView queryItem() throws Exception{
        Items items = this.itemsService.selectByPrimaryKey(1);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items",items);
        modelAndView.setViewName("WEB-INF/itemsList");
        return modelAndView;
    }
}
