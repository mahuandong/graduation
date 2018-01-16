package com.cn.controller;

import com.cn.pojo.Items;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {
    @RequestMapping("/queryItem")
    public ModelAndView queryItem() throws Exception{
        List<Items> itemsList = new ArrayList<Items>();
        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000F);
        items_1.setDetail("ThinkPad T430");

        Items items_2 = new Items();
        items_2.setName("IPone");
        items_2.setPrice(5000F);
        items_2.setDetail("iPone6");

        itemsList.add(items_1);
        itemsList.add(items_2);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("WEB-INF/itemsList");
        return modelAndView;
    }
}
