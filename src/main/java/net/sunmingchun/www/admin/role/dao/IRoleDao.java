package net.sunmingchun.www.admin.role.dao;

import net.sunmingchun.www.admin.role.po.RolePO;
import net.sunmingchun.www.admin.role.po.RoleResourcePO;
import net.sunmingchun.www.base.dao.IDao;

import java.util.List;
import java.util.Map;

/**
 * Created by smc on 2016/1/18.
 */
public interface IRoleDao extends IDao<RolePO> {

    public void deleteRoleResource(String roleId);

    public void saveRoleResource(RoleResourcePO roleResourcePO);

    public List<String> selectResIdsByRoleId(String roleId);

}
