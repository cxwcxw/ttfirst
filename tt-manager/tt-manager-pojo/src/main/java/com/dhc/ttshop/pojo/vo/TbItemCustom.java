package com.dhc.ttshop.pojo.vo;

import com.dhc.ttshop.pojo.po.TbItem;

/**
 * Created by Administrator on 2017/9/4.
 */
public class TbItemCustom extends TbItem {
    private String catName;
    private String statusName;
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
