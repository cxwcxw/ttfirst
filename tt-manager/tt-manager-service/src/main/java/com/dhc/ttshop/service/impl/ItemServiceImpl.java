package com.dhc.ttshop.service.impl;

import com.dhc.ttshop.common.PageBean;
import com.dhc.ttshop.common.Result;
import com.dhc.ttshop.dao.TbItemMapper;
import com.dhc.ttshop.dao.TbItemMapperCustom;
import com.dhc.ttshop.pojo.po.TbItem;
import com.dhc.ttshop.pojo.po.TbItemExample;
import com.dhc.ttshop.pojo.vo.TbItemCustom;
import com.dhc.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * User: DHC
 * Date: 2017/8/31
 * Time: 15:01
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemMapperCustom tbItemMapperCustom;

    @Override
    public TbItem getById(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result<TbItemCustom> listItems(PageBean pageBean) {
        List<TbItemCustom> list = tbItemMapperCustom.selectByPage(pageBean);
        long count = tbItemMapperCustom.counts();
        Result<TbItemCustom> rs = new Result<TbItemCustom>();
        rs.setTotal(count);
        rs.setRows(list);
        return rs;
    }
    public int delectItem(List<Long> ids){
        TbItem tbItem = new TbItem();
        tbItem.setStatus((byte)3);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return tbItemMapper.updateByExampleSelective(tbItem,example);
    }
    public int upItem(List<Long> ids){
        TbItem tbItem = new TbItem();
        tbItem.setStatus((byte)1);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return tbItemMapper.updateByExampleSelective(tbItem,example);
    }
    public int downItem(List<Long> ids){
        TbItem tbItem = new TbItem();
        tbItem.setStatus((byte)2);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return tbItemMapper.updateByExampleSelective(tbItem,example);
    }
}
