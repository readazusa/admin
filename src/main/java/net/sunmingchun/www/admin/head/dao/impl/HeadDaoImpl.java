package net.sunmingchun.www.admin.head.dao.impl;

import net.sunmingchun.www.admin.head.dao.IHeadDao;
import net.sunmingchun.www.admin.head.po.HeadPO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by smc on 2016/1/22.
 */
@Repository
public class HeadDaoImpl extends SqlSessionDaoSupport implements IHeadDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void save(HeadPO headPO) {

    }
}
