package com.cn.service.Impl;

import com.cn.mapper.ItemsMapper;
import com.cn.pojo.Items;
import com.cn.service.ItemService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemsMapper itemsMapper;
    @Override
    public Items selectByPrimaryKey(int id) {
        return this.itemsMapper.selectByPrimaryKey(id);
    }
}
