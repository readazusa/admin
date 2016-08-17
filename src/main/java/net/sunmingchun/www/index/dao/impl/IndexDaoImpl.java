package net.sunmingchun.www.index.dao.impl;

import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.index.dao.IIndexDao;
import net.sunmingchun.www.index.po.IndexPageInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 念梓  on 2016/8/17.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Repository
public class IndexDaoImpl extends SqlSessionDaoSupport implements IIndexDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void save(IndexPageInfo obj) {
        this.getSqlSession().insert("IndexPageInfo.save",obj);
    }

    @Override
    public void deleteById(String uid) {
        this.getSqlSession().delete("IndexPageInfo.delete",uid);
    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(IndexPageInfo indexPageInfo) {
        this.getSqlSession().update("IndexPageInfo.update",indexPageInfo);
    }

    @Override
    public IndexPageInfo queryObjectById(String id) {
        List<IndexPageInfo> indexPageInfoList = this.getSqlSession().selectList("IndexPageInfo.select",id);
        return indexPageInfoList.size()>0?indexPageInfoList.get(0):null;
    }

    @Override
    public IndexPageInfo queryObjectById(int id) {
        return null;
    }

    @Override
    public List<IndexPageInfo> queryList() {
        return null;
    }

    @Override
    public int queryTotalCount(IndexPageInfo indexPageInfo) {
        return this.getSqlSession().selectOne("IndexPageInfo.queryTotalCount",indexPageInfo);
    }

    @Override
    public List<IndexPageInfo> queryPage(BaseSearchPO<IndexPageInfo> baseSearchPO) {
        return this.getSqlSession().selectList("IndexPageInfo.queryPage",baseSearchPO);
    }

    @Override
    public int queryTotalCount(BaseSearchPO<IndexPageInfo> baseSearchPO) {
        return 0;
    }
}
