package net.sunmingchun.www.admin.user.service.impl;

import net.sunmingchun.www.admin.role.dao.IRoleDao;
import net.sunmingchun.www.admin.role.po.RolePO;
import net.sunmingchun.www.admin.user.dao.IUserDao;
import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.admin.user.po.UserRolePO;
import net.sunmingchun.www.admin.user.service.IUserService;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.util.DESUtils;
import net.sunmingchun.www.util.UuidUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by smc on 2015/12/6.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Resource
    private IRoleDao roleDao;
    @Override
    public void save(UserPO obj) {
       if(StringUtils.isBlank(obj.getId())){
           obj.setId(UuidUtils.getUpperUuid());
           obj.setCreateTime(new Date());
           obj.setUpdateTime(new Date());
       }
       obj.setPassword( DESUtils.encrypt(obj.getPassword()));
       userDao.save(obj);
    }

    @Override
    @Transactional
    public void deleteById(String uid) {
        userDao.deleteUserRoleByUserId(uid);
        userDao.deleteById(uid);
    }

    @Override
    public void deleteById(int uid) {
        userDao.deleteById(uid);
    }

    @Override
    public void update(UserPO t) {
        t.setUpdateTime(new Date());
        userDao.update(t);
    }

    @Override
    public UserPO queryObjectById(String id) {

        return userDao.queryObjectById(id);
    }

    @Override
    public UserPO queryObjectById(int id) {
        return userDao.queryObjectById(id);
    }

    @Override
    public List<UserPO> queryListPO(int pageIndex, int pageSize, UserPO userPO) {
        BaseSearchPO<UserPO> baseSearchPO = new BaseSearchPO<>();
        baseSearchPO.setObj(userPO);
        baseSearchPO.setPageIndex(pageIndex);
        baseSearchPO.setPageSize(pageSize);
        return userDao.queryPage(baseSearchPO);
    }

    @Override
    public int getTotalCount(UserPO userPO) {
        return userDao.queryTotalCount(userPO);
    }

    @Override
    public BasePagePO<UserPO> getBasePagePO(int pageIndex, int pageSize, UserPO userPO) {
        BasePagePO<UserPO> basePagePO = new BasePagePO<>();
        List<UserPO> userPOList = this.queryListPO(pageIndex,pageSize,userPO);
        int totalCount = this.getTotalCount(userPO);
        return null;
    }



    @Override
    public BasePagePO<UserPO> getBasePagePO(int pageIndex, int pageSize, UserPO userPO, int draw) {
        BasePagePO<UserPO> basePagePO = new BasePagePO<>();
        List<UserPO> userPOList = this.queryListPO(pageIndex,pageSize,userPO);
        int totalCount = this.getTotalCount(userPO);
        basePagePO.setData(userPOList);
        basePagePO.setDraw(draw);
        basePagePO.setRecordsTotal(totalCount);
        basePagePO.setRecordsFiltered(totalCount);
        return basePagePO;
    }

    @Override
    public BasePagePO<UserPO> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw) {
        UserPO userPO = new UserPO();
        userPO.setSearch(searchValue);
        BaseSearchPO<UserPO> baseSearchPO = new BaseSearchPO<>();
        baseSearchPO.setObj(userPO);
        baseSearchPO.setPageSize(pageSize);
        baseSearchPO.setPageIndex(pageIndex);
        baseSearchPO.setOrderName(orderColumn);
        baseSearchPO.setOrderValue(orderValue);
        /*
         *上面是构造查询条件
         *
         * 下面是返回查询结构
         */
        List<UserPO> userPOList = userDao.queryPage(baseSearchPO);
        int totalCount = this.getTotalCount(userPO);
        BasePagePO<UserPO> basePagePO = new BasePagePO<>();
        basePagePO.setData(userPOList);
        basePagePO.setDraw(draw);
        basePagePO.setRecordsTotal(totalCount);
        basePagePO.setRecordsFiltered(totalCount);
        return basePagePO;
    }

    @Override
    public void saveUserRole(String userId, String roleIds) {
        if(StringUtils.isNotBlank(roleIds)){
            userDao.deleteUserRoleByUserId(userId);

            String[] rids = roleIds.split(",");
            UserRolePO userRolePO = new UserRolePO();
            for(String roleId: rids){
                userRolePO.setId(UuidUtils.getUpperUuid());
                userRolePO.setRoleId(roleId);
                userRolePO.setUserId(userId);
                userRolePO.setCreateTime(new Date());
                userDao.saveUserRole(userRolePO);
            }
        }
    }

    @Override
    public List<UserPO> queryList() {
        return null;
    }

    @Override
    public List<RolePO> queryRoleList(String userId) {
        List<RolePO> rolePOList = roleDao.queryList();
        List<String> roleIds = userDao.selectRoleIdsByUserId(userId);
        if(roleIds != null && roleIds.size()>0){
            if(rolePOList != null && rolePOList.size()>0){
                for(RolePO rolePO : rolePOList){
                    if(roleIds.contains(rolePO.getId())){
                        rolePO.setExist(0);
                    }
                }
            }
        }
        return rolePOList;
    }
}
