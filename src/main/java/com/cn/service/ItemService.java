package com.cn.service;

import com.cn.pojo.Items;


public interface ItemService {
    public Items selectByPrimaryKey(int id) throws Exception;
}
