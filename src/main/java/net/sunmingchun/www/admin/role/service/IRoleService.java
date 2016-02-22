package net.sunmingchun.www.admin.role.service;

import net.sunmingchun.www.admin.resource.po.ResourcePO;
import net.sunmingchun.www.admin.role.po.RolePO;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.service.IService;

import java.util.List;

/**
 * Created by smc on 2016/1/18.
 */
public interface IRoleService extends IService<RolePO> {

    public BasePagePO<RolePO> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw);

    /**
     *
     * @param roleId
     * @param resourceIds  (以逗号分隔的资源id)
     *
     */
    public void saveRoleResource(String roleId, String resourceIds);

    public List<ResourcePO>  queryResourcePOByRoleId(String roleId);


}
