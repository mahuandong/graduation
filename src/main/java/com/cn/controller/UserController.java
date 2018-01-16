package com.cn.controller;

import com.cn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

//使用Controller标识他是一个控制器
@Controller
public class UserController {
    @RequestMapping("/queryUser")
    //用户查询列表
    public ModelAndView queryUser() throws Exception{

        List<User> userList = new ArrayList<User>();

        User user1 = new User();
        user1.setUsername("小明");
        user1.setSex("男");
        user1.setAddress("北京");

        User user2 = new User();
        user2.setUsername("小红");
        user2.setSex("女");
        user2.setAddress("北京");

        userList.add(user1);
        userList.add(user2);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("WEB-INF/userList");
        return modelAndView;
    }
}
