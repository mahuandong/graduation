package com.cn.controller;

import com.cn.pojo.User;
import com.cn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

//使用Controller标识他是一个控制器
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value = {"userSelectAll.json"},method = {RequestMethod.GET})
    public @ResponseBody
    List<User> selectAll()throws Exception{
        List<User> list = this.userService.selectAll();
        return list;
    }
    //按name查询用户
    @RequestMapping(value = { "login.json" }, method = { RequestMethod.POST })
    public @ResponseBody
    User selectByName(String account, String password) throws Exception {
        User parameter = new User();
        parameter.setAccount(account);
        parameter.setPassword(password);
        return this.userService.selectByName(parameter);
    }
    @RequestMapping(value = { "userInsert.json" },method = { RequestMethod.POST })
    public @ResponseBody int insert(String name,String account,String password,Integer phone,Integer sex,String email) throws Exception{
        User parameter = new User();
        parameter.setName(name);
        parameter.setAccount(account);
        parameter.setPassword(password);
        parameter.setPhone(phone);
        parameter.setSex(sex);
        parameter.setEmail(email);
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String s= formatter.format(new Date());
        Date date =  formatter.parse(s);
        parameter.setCreatetime(date);
        parameter.setUpdatetime(date);
        return this.userService.insert(parameter);
    }

    @RequestMapping(value = { "userDelete.json" },method = { RequestMethod.POST })
    public @ResponseBody int deleteByPrimaryKey(Integer id)throws Exception{
        return this.userService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = { "userUpdate.json" },method = { RequestMethod.POST })
    public @ResponseBody Object updateByPrimaryKey(Integer id,String name,String account,String password,
                                                Integer phone,Integer sex,String email)
            throws Exception{
        User parameter = new User();
        parameter.setId(id);
        parameter.setName(name);
        parameter.setAccount(account);
        parameter.setPassword(password);
        parameter.setPhone(phone);
        parameter.setSex(sex);
        parameter.setEmail(email);
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String s= formatter.format(new Date());
        Date date =  formatter.parse(s);
        parameter.setUpdatetime(date);
        Map<String, Object> result = this.userService.updateByPrimaryKey(parameter);
        return result;
    }
//    @RequestMapping("user")
//    public ModelAndView user(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("WEB-INF/user.jsp");
//        return modelAndView;
//    }
}
