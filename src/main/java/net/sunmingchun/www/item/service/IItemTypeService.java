package net.sunmingchun.www.item.service;

import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.service.IService;
import net.sunmingchun.www.item.po.ItemTypeInfo;

/**
 * Created by 念梓  on 2016/8/15.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
public interface IItemTypeService extends IService<ItemTypeInfo> {

    public BasePagePO<ItemTypeInfo> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw);

}
