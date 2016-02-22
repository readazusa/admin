package net.sunmingchun.www.admin.area.dao.impl;

import net.sunmingchun.www.admin.area.dao.IAreaDao;
import net.sunmingchun.www.admin.area.po.AreaPO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by smc on 2016/1/11.
 */
@Repository
public class IAreaDaoImpl extends SqlSessionDaoSupport  implements IAreaDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<AreaPO> queryAreaByParentId(String id) {
        return this.getSqlSession().selectList("AreaPO.queryAreaByParentId",id);
    }
}
