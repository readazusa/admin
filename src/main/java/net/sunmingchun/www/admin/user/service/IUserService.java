package net.sunmingchun.www.admin.user.service;



import net.sunmingchun.www.admin.role.po.RolePO;
import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.service.IService;

import java.util.List;

/**
 * Created by smc on 2015/12/6.
 */
public interface IUserService extends IService<UserPO> {


    public BasePagePO<UserPO> getBasePagePO(int pageIndex, int pageSize, UserPO userPO, int draw);



    public BasePagePO<UserPO> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw);


    public void saveUserRole(String userId, String roleIds);

    /**
     * 获取选中和没选中的角色
     * @param userId
     * @return
     */
    public List<RolePO> queryRoleList(String userId);


}
