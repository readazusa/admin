package net.sunmingchun.www.admin.log.service;

import net.sunmingchun.www.admin.log.po.VisitLogPO;
import net.sunmingchun.www.admin.role.po.RolePO;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.service.IService;

/**
 * net.sunmingchun.www.admin.log.service
 * Created by smc
 * date on 2016/3/28.
 * Email:sunmch@163.com
 */
public interface IVisLogService extends IService<VisitLogPO> {

    public BasePagePO<VisitLogPO> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw);


}
