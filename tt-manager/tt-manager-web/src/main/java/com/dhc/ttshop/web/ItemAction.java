package com.dhc.ttshop.web;

import com.dhc.ttshop.common.PageBean;
import com.dhc.ttshop.common.Result;
import com.dhc.ttshop.pojo.po.TbItem;
import com.dhc.ttshop.pojo.vo.TbItemCustom;
import com.dhc.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * User: DHC
 * Date: 2017/8/31
 * Time: 15:05
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemAction {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    @ResponseBody
    public TbItem getById(@PathVariable Long itemId){
        return itemService.getById(itemId);
    }

    @RequestMapping("/items")
    @ResponseBody
    public Result<TbItemCustom> listItems(PageBean pageBean){
        return itemService.listItems(pageBean);
    }
    @RequestMapping(value = "/items/batch",method = RequestMethod.POST)
    @ResponseBody
    public int delectItem(@RequestParam("ids[]") List<Long> ids){
        return itemService.delectItem(ids);
    }

    @RequestMapping(value = "/items/up",method = RequestMethod.POST)
     @ResponseBody
     public int upItem(@RequestParam("ids[]") List<Long> ids){
        return itemService.upItem(ids);
    }
    @RequestMapping(value = "/items/down",method = RequestMethod.POST)
    @ResponseBody
    public int udownItem(@RequestParam("ids[]") List<Long> ids){
        return itemService.downItem(ids);
    }
}
