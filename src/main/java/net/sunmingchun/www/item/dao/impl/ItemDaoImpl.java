package net.sunmingchun.www.item.dao.impl;

import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.item.dao.IItemDao;
import net.sunmingchun.www.item.po.ItemInfo;
import net.sunmingchun.www.item.po.ItemVsFilePO;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * net.sunmingchun.www.item.dao.impl
 * Created by smc
 * date on 2016/4/27.
 * Email:sunmch@163.com
 */
@Repository
public class ItemDaoImpl extends SqlSessionDaoSupport  implements IItemDao {


    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void save(ItemInfo obj) {
        this.getSqlSession().insert("ItemInfo.save",obj);
    }

    @Override
    public void deleteById(String uid) {

    }

    @Override
    public void deleteById(int uid) {

    }
    @Override
    public void update(ItemInfo itemInfo) {

    }
    @Override
    public ItemInfo queryObjectById(String id) {
        return this.getSqlSession().selectOne("ItemInfo.select",id);
    }

    @Override
    public ItemInfo queryObjectById(int id) {
        return null;
    }

    @Override
    public List<ItemInfo> queryList() {
        return null;
    }

    @Override
    public int queryTotalCount(ItemInfo itemInfo) {
        return this.getSqlSession().selectOne("ItemInfo.queryTotalCount",itemInfo);
    }

    @Override
    public List<ItemInfo> queryPage(BaseSearchPO<ItemInfo> baseSearchPO) {
        return this.getSqlSession().selectList("ItemInfo.queryPage",baseSearchPO);
    }

    @Override
    public int queryTotalCount(BaseSearchPO<ItemInfo> baseSearchPO) {
        return this.getSqlSession().selectOne("ItemInfo.queryPageTotalCount",baseSearchPO);
    }

    @Override
    public int saveItemVsFile(ItemVsFilePO itemVsFilePO) {
        return this.getSqlSession().insert("ItemVsFilePO.save",itemVsFilePO);
    }
}
