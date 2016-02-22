package net.sunmingchun.www.admin.resource.service;

import net.sunmingchun.www.admin.resource.po.ResourcePO;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.service.IService;

/**
 * Created by smc on 2016/1/18.
 */
public interface IResourceService extends IService<ResourcePO> {

    public BasePagePO<ResourcePO> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw);

}
