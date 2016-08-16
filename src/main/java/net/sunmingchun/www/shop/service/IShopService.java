package net.sunmingchun.www.shop.service;

import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.service.IService;
import net.sunmingchun.www.item.po.ItemInfo;
import net.sunmingchun.www.shop.po.ShopInfo;

import java.util.List;

/**
 * net.sunmingchun.www.item.service
 * Created by smc
 * date on 2016/4/27.
 * Email:sunmch@163.com
 */
public interface IShopService extends IService<ShopInfo> {



    public BasePagePO<ShopInfo> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw);

    /**
     * 获取主从的店铺信息
     * @param index
     * @return
     */
    public List<ShopInfo> getListByIndex(String index);
}
