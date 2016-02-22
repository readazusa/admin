package net.sunmingchun.www.admin.resource.dao.impl;

import net.sunmingchun.www.admin.resource.dao.IResourceDao;
import net.sunmingchun.www.admin.resource.po.ResourcePO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by smc on 2016/1/19.
 */
@Repository
public class ResourceDaoImpl extends SqlSessionDaoSupport implements IResourceDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void save(ResourcePO obj) {
        this.getSqlSession().insert("ResourcePO.save", obj);
    }

    @Override
    public void deleteById(String uid) {
        this.getSqlSession().delete("ResourcePO.delete",uid);
    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(ResourcePO resourcePO) {
        this.getSqlSession().update("ResourcePO.update",resourcePO);
    }

    @Override
    public ResourcePO queryObjectById(String id) {
        return this.getSqlSession().selectOne("ResourcePO.select",id);
    }

    @Override
    public ResourcePO queryObjectById(int id) {
        return this.getSqlSession().selectOne("ResourcePO.select",id);
    }

    @Override
    public int queryTotalCount(ResourcePO resourcePO) {
        return this.getSqlSession().selectOne("ResourcePO.queryTotalCount",resourcePO);
    }

    public List<ResourcePO> queryPage(BaseSearchPO<ResourcePO> baseSearchPO) {

        return this.getSqlSession().selectList("ResourcePO.queryPage",baseSearchPO);
    }

    @Override
    public List<ResourcePO> queryList() {
        return this.getSqlSession().selectList("ResourcePO.queryList");
    }
}
