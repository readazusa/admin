package net.sunmingchun.www.admin.role.dao.impl;

import net.sunmingchun.www.admin.role.dao.IRoleDao;
import net.sunmingchun.www.admin.role.po.RolePO;
import net.sunmingchun.www.admin.role.po.RoleResourcePO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by smc on 2016/1/18.
 */
@Repository
public class RoleDaoImpl extends SqlSessionDaoSupport implements IRoleDao {


    @Override
    public void save(RolePO obj) {
        this.getSqlSession().insert("RolePO.save",obj);
    }

    @Override
    public void deleteById(String uid) {
        this.getSqlSession().delete("RolePO.delete",uid);
    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(RolePO rolePO) {
        this.getSqlSession().update("RolePO.update",rolePO);
    }

    @Override
    public RolePO queryObjectById(String id) {
        return this.getSqlSession().selectOne("RolePO.select",id);
    }

    @Override
    public RolePO queryObjectById(int id) {
        return null;
    }

    @Override
    public int queryTotalCount(RolePO rolePO) {
        return this.getSqlSession().selectOne("RolePO.queryTotalCount",rolePO);
    }

    @Override
    public List<RolePO> queryPage(BaseSearchPO<RolePO> baseSearchPO) {
        return this.getSqlSession().selectList("RolePO.queryPage",baseSearchPO);
    }


    @Override
    public void deleteRoleResource(String roleId) {
        this.getSqlSession().delete("RolePO.deleteRoleResource",roleId);
    }

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void saveRoleResource(RoleResourcePO roleResourcePO) {
        this.getSqlSession().insert("RolePO.saveRoleResource",roleResourcePO);
    }

    @Override
    public List<RolePO> queryList() {
        return this.getSqlSession().selectList("RolePO.queryList");
    }

    @Override
    public List<String> selectResIdsByRoleId(String roleId) {
        return this.getSqlSession().selectList("RolePO.selectResIdsByRoleId",roleId);
    }

    @Override
    public int queryTotalCount(BaseSearchPO<RolePO> baseSearchPO) {
        return this.getSqlSession().selectOne("RolePO.queryPageTotalCount",baseSearchPO);
    }
}
