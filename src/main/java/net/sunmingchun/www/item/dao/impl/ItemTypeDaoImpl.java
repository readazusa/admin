package net.sunmingchun.www.item.dao.impl;

import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.item.dao.IItemTypeDao;
import net.sunmingchun.www.item.po.ItemTypeInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 念梓  on 2016/8/15.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Repository
public class ItemTypeDaoImpl extends SqlSessionDaoSupport implements IItemTypeDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void save(ItemTypeInfo obj) {
        this.getSqlSession().insert("ItemTypeInfo.save", obj);
    }

    @Override
    public void deleteById(String uid) {
        this.getSqlSession().delete("ItemTypeInfo.delete", uid);
    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(ItemTypeInfo itemTypeInfo) {
        this.getSqlSession().update("ItemTypeInfo.update", itemTypeInfo);
    }

    @Override
    public ItemTypeInfo queryObjectById(String id) {
        List<ItemTypeInfo> itemTypeInfos = this.getSqlSession().selectList("ItemTypeInfo.select", id);
        return itemTypeInfos.size() > 0 ? itemTypeInfos.get(0) : null;
    }

    @Override
    public ItemTypeInfo queryObjectById(int id) {
        return null;
    }

    @Override
    public List<ItemTypeInfo> queryList() {
        return this.getSqlSession().selectList("ItemTypeInfo.queryList");
    }

    @Override
    public int queryTotalCount(ItemTypeInfo itemTypeInfo) {
        return this.getSqlSession().selectOne("ItemTypeInfo.queryTotalCount", itemTypeInfo);
    }

    @Override
    public List<ItemTypeInfo> queryPage(BaseSearchPO<ItemTypeInfo> baseSearchPO) {
        return this.getSqlSession().selectList("ItemTypeInfo.queryPage", baseSearchPO);
    }

    @Override
    public int queryTotalCount(BaseSearchPO<ItemTypeInfo> baseSearchPO) {
        return 0;
    }
}
