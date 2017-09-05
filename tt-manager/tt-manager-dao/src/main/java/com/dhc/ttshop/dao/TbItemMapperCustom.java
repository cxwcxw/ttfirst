package com.dhc.ttshop.dao;

import com.dhc.ttshop.common.PageBean;
import com.dhc.ttshop.pojo.vo.TbItemCustom;

import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */
public interface TbItemMapperCustom {
    long counts();
    List<TbItemCustom> selectByPage(PageBean pageBean);
}
