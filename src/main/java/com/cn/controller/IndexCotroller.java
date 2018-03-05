package com.cn.controller;

import com.cn.pojo.Area;
import com.cn.pojo.Index;
import com.cn.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 创建时间：2018/03/05 1:01
 * 项目名称：graduation
 *
 * @author mahua
 * Package com.cn.controller
 * @version 1.0
 * 类说明：
 */

@Controller
public class IndexCotroller {
    @Autowired
    private IndexService indexService;
    //全查询
    @RequestMapping(value = {"selectByTable.json"},method = {RequestMethod.GET})
    public @ResponseBody
    List<Index> selectByTable(String table) throws Exception {
        return this.indexService.selectByTable(table);
    }
}
