package com.cn.service.Impl;

import com.cn.mapper.ItemsMapper;
import com.cn.pojo.Items;
import com.cn.service.ItemsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ItemsServiceImpl implements ItemsService {
    @Resource
    private ItemsMapper itemsMapper;
    @Override
    public Items selectByPrimaryKey(Integer id) {
        return this.itemsMapper.selectByPrimaryKey(id);
    }
}
