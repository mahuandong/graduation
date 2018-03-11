package com.cn.service.Impl;

import com.cn.mapper.User.UserMapper;
import com.cn.pojo.User;
import com.cn.service.UserService;
import com.cn.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return this.userMapper.selectAll();
    }

    @Override
    public User selectByName(User record) throws Exception {
        String account = record.getAccount();
        String password = record.getPassword();
        return this.userMapper.selectByName(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) throws Exception {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(User record) throws Exception {
        return this.userMapper.insertSelective(record);
    }

    @Override
    public int insert(User parameter){
        String name = parameter.getName();
        String account = parameter.getAccount();
        String password = parameter.getPassword();
        Integer phone = parameter.getPhone();
        Integer sex = parameter.getSex();
        String email = parameter.getEmail();
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String s= formatter.format(new Date());
        Date date = null;
        try {
            date = formatter.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        parameter.setCreatetime(date);
        parameter.setUpdatetime(date);
        if (name == null && account == null && password == null) {
            System.out.println("name、account、password至少有一个为空");
            return 406;
        }
        int rows = userMapper.insert(parameter);
        return rows;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) throws Exception {
        //如果id为空值返回406
        if (StringUtils.isEmpty(id)) {
            System.out.println("id为空");
            return 406;
        }
        int rows = userMapper.deleteByPrimaryKey(id);
        if (rows > 0) {
            return 1;
        }
        return rows;
    }

    @Override
    public Map<String, Object> updateByPrimaryKey(User record) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        Integer id = record.getId();
        String name = record.getName();
        String account = record.getAccount();
        String password = record.getPassword();
        Integer phone = record.getPhone();
        Integer sex = record.getSex();
        String email = record.getEmail();
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String s= formatter.format(new Date());
        Date date = null;
        try {
            date = formatter.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        record.setUpdatetime(date);
        if (id == null){
            ResultUtils.paramsError406(result, "id不能为空");
            return result;
        }
        if (name == null && account == null && password == null && phone == null && sex == null && email == null) {
            ResultUtils.paramsError406(result, "至少要有1个参数有值");
            return result;
        }
        int rows = userMapper.updateByPrimaryKey(record);
        if (rows == 1) {
            ResultUtils.resultCodeOk(result);
            return result;
        }
        result.put("rows", rows);
        return result;
    }
}
