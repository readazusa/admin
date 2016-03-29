package net.sunmingchun.www.admin.log.dao.impl;

import net.sunmingchun.www.admin.log.dao.ILogDao;
import net.sunmingchun.www.admin.log.po.OperationLogPO;
import net.sunmingchun.www.admin.log.po.VisitLogPO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * net.sunmingchun.www.admin.log.dao.impl
 * Created by smc
 * date on 2016/3/3.
 * Email:sunmch@163.com
 */
@Repository
public class LogDaoImpl extends SqlSessionDaoSupport implements ILogDao{

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void insertVisitPO(VisitLogPO visitLogPO) {
        this.getSqlSession().insert("LogPO.insertVisitLog",visitLogPO);
    }

    @Override
    public void insertOperationPO(OperationLogPO operationLogPO) {
        this.getSqlSession().insert("LogPO.insertOperationLog",operationLogPO);
    }

    @Override
    public List<VisitLogPO> queryVisPage(BaseSearchPO<VisitLogPO> baseSearchPO) {
        return this.getSqlSession().selectList("LogPO.queryVisPage",baseSearchPO);
    }

    @Override
    public List<OperationLogPO> queryOperPage(BaseSearchPO<OperationLogPO> baseSearchPO) {
        return this.getSqlSession().selectList("LogPO.queryOperPage",baseSearchPO);
    }

    @Override
    public int queryVisTotalCount(VisitLogPO visitLogPO) {
        return this.getSqlSession().selectOne("LogPO.queryVisTotalCount",visitLogPO);
    }

    @Override
    public int queryOperoTotalCount(OperationLogPO operationLogPO) {
        return this.getSqlSession().selectOne("LogPO.queryOperTotalCount",operationLogPO);
    }

    @Override
    public VisitLogPO queryVisObjectById(String id) {
        return this.getSqlSession().selectOne("LogPO.queryVisObjectById",id);
    }

    @Override
    public OperationLogPO queryOperObjectById(String id) {
        return this.getSqlSession().selectOne("LogPO.queryOperObjectById",id);
    }
}
