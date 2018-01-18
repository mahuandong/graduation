package com.cn.controller;

import com.cn.pojo.User;
import com.cn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

//使用Controller标识他是一个控制器
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/queryUser")
    //用户查询列表
    public ModelAndView queryUser() throws Exception{
        User user = this.userService.selectByPrimaryKey(1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("WEB-INF/userList");
        return modelAndView;
    }
}
