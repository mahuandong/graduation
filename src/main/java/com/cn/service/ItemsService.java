package com.cn.service;

import com.cn.pojo.Items;

public interface ItemsService {
     Items selectByPrimaryKey(Integer id) throws Exception;
}
