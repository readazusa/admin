package net.sunmingchun.www.admin.user.dao;



import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.admin.user.po.UserRolePO;
import net.sunmingchun.www.base.dao.IDao;

import java.util.List;

/**
 * Created by smc on 2015/11/19.
 */
public interface IUserDao extends IDao<UserPO> {


    public void deleteUserRoleByUserId(String userId);

    public void saveUserRole(UserRolePO userRolePO);

    public List<String> selectRoleIdsByUserId(String userId);

}
