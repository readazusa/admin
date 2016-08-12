package net.sunmingchun.www.item.dao;

import net.sunmingchun.www.base.dao.IDao;
import net.sunmingchun.www.item.po.ItemInfo;
import net.sunmingchun.www.item.po.ItemVsFilePO;

/**
 * net.sunmingchun.www.item.dao
 * Created by smc
 * date on 2016/4/27.
 * Email:sunmch@163.com
 */
public interface IItemDao extends IDao<ItemInfo>{

    public int saveItemVsFile(ItemVsFilePO itemVsFilePO);
}
