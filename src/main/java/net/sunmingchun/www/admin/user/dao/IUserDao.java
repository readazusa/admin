package net.sunmingchun.www.admin.user.dao;

import net.sunmingchun.admin.user.po.UserPO;
import net.sunmingchun.admin.user.po.UserRolePO;
import net.sunmingchun.base.dao.IDao;
import net.sunmingchun.base.po.BasePagePO;
import net.sunmingchun.base.po.BaseSearchPO;

import java.util.List;

/**
 * Created by smc on 2015/11/19.
 */
public interface IUserDao extends IDao<UserPO> {


    public void deleteUserRoleByUserId(String userId);

    public void saveUserRole(UserRolePO userRolePO);

    public List<String> selectRoleIdsByUserId(String userId);

}
