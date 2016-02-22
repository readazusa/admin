package net.sunmingchun.www.admin.role.service.impl;

import net.sunmingchun.admin.resource.dao.IResourceDao;
import net.sunmingchun.admin.resource.po.ResourcePO;
import net.sunmingchun.admin.role.dao.IRoleDao;
import net.sunmingchun.admin.role.po.RolePO;
import net.sunmingchun.admin.role.po.RoleResourcePO;
import net.sunmingchun.admin.role.service.IRoleService;
import net.sunmingchun.base.po.BasePagePO;
import net.sunmingchun.base.po.BaseSearchPO;
import net.sunmingchun.util.UuidUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by smc on 2016/1/18.
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    private IRoleDao roleDao;

    @Resource
    private IResourceDao resourceDao;

    @Override
    public RolePO queryObjectById(String id) {

        return roleDao.queryObjectById(id);
    }

    @Override
    public RolePO queryObjectById(int id) {
        return null;
    }

    @Override
    public void save(RolePO obj) {
        if(StringUtils.isBlank(obj.getId())){
            obj.setId(UuidUtils.getUpperUuid());
            obj.setCreateTime(new Date());
            obj.setUpdateTime(new Date());
        }
        roleDao.save(obj);
    }

    @Override
    public void deleteById(String uid) {
        roleDao.deleteRoleResource(uid);
        roleDao.deleteById(uid);
    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(RolePO rolePO) {
        rolePO.setUpdateTime(new Date());
        roleDao.update(rolePO);
    }

    @Override
    public int getTotalCount(RolePO rolePO) {
        return roleDao.queryTotalCount(rolePO);
    }

    @Override
    public BasePagePO<RolePO> getBasePagePO(int pageIndex, int pageSize, RolePO rolePO) {
        return null;
    }

    @Override
    public List<RolePO> queryListPO(int pageIndex, int pageSize, RolePO rolePO) {
        return null;
    }


    @Override
    public BasePagePO<RolePO> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw) {
        BaseSearchPO<RolePO> baseSearchPO = new BaseSearchPO<>();
        baseSearchPO.setOrderValue(orderValue);
        baseSearchPO.setOrderName(orderColumn);
        baseSearchPO.setPageSize(pageSize);
        RolePO rolePO = new RolePO();
        rolePO.setSearch(searchValue);
        baseSearchPO.setObj(rolePO);
        List<RolePO> list = roleDao.queryPage(baseSearchPO);
        int total = roleDao.queryTotalCount(rolePO);
        BasePagePO<RolePO> basePagePO = new BasePagePO<>();
        basePagePO.setData(list);
        basePagePO.setDraw(draw);
        basePagePO.setRecordsFiltered(total);
        basePagePO.setRecordsTotal(total);
        return basePagePO;
    }

    @Override
    @Transactional
    public void saveRoleResource(String roleId, String resourceIds) {
        if(StringUtils.isNotBlank(resourceIds)){
            roleDao.deleteRoleResource(roleId);
            String[] resIds = resourceIds.split(",");
            RoleResourcePO roleResourcePO = new RoleResourcePO();
            for(String resId: resIds){
                roleResourcePO.setId(UuidUtils.getUpperUuid());
                roleResourcePO.setRoleId(roleId);
                roleResourcePO.setResourceId(resId);
                roleResourcePO.setCreateTime(new Date());
                roleDao.saveRoleResource(roleResourcePO);
            }
        }
    }

    @Override
    public List<RolePO> queryList() {
        return roleDao.queryList();
    }


    @Override
    public List<ResourcePO> queryResourcePOByRoleId(String roleId) {
        List<ResourcePO> resourcePOList = resourceDao.queryList();
        List<String> resIds = roleDao.selectResIdsByRoleId(roleId);
        if(resIds != null && resIds.size()>0){
            if(resourcePOList != null && resourcePOList.size()>0){
                for(ResourcePO resourcePO: resourcePOList){
                    if(resIds.contains(resourcePO.getId())){
                        resourcePO.setExist(0);
                    }
                }
            }
        }
        return resourcePOList;
    }
}
