package net.sunmingchun.www.item.service;

import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.service.IService;
import net.sunmingchun.www.item.po.ItemInfo;

/**
 * net.sunmingchun.www.item.service
 * Created by smc
 * date on 2016/4/27.
 * Email:sunmch@163.com
 */
public interface IItemService extends IService<ItemInfo> {

    public BasePagePO<ItemInfo> getBasePagePO(int pageIndex, int pageSize, UserPO userPO, int draw);


    public BasePagePO<ItemInfo> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw);





}
