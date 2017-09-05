package com.dhc.ttshop.service;

import com.dhc.ttshop.common.PageBean;
import com.dhc.ttshop.common.Result;
import com.dhc.ttshop.pojo.po.TbItem;
import com.dhc.ttshop.pojo.vo.TbItemCustom;

import java.util.List;

/**
 * User: DHC
 * Date: 2017/8/31
 * Time: 15:00
 * Version:V1.0
 */
public interface ItemService {
    TbItem getById(Long id);

    Result<TbItemCustom> listItems(PageBean pageBean);
    int delectItem(List<Long> ids);
    int upItem(List<Long> ids);
    int downItem(List<Long> ids);
}
