package net.sunmingchun.www.admin.log.dao.impl;

import net.sunmingchun.www.admin.log.dao.ILogDao;
import net.sunmingchun.www.admin.log.po.OperationLogPO;
import net.sunmingchun.www.admin.log.po.VisitLogPO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
