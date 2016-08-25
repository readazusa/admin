package net.sunmingchun.www.shop.dao.impl;

import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.shop.dao.IShopDao;
import net.sunmingchun.www.shop.po.ShopInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 念梓  on 2016/8/15.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Repository
public class ShopDaoImpl extends SqlSessionDaoSupport implements IShopDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void save(ShopInfo obj) {
        this.getSqlSession().insert("ShopInfo.save",obj);
    }

    @Override
    public void deleteById(String uid) {
        this.getSqlSession().delete("ShopInfo.delete",uid);
    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(ShopInfo shopInfo) {
        this.getSqlSession().update("ShopInfo.update",shopInfo);
    }

    @Override
    public ShopInfo queryObjectById(String id) {
        List<ShopInfo> shopInfos = this.getSqlSession().selectList("ShopInfo.select",id);
        return shopInfos.size()>0?shopInfos.get(0):null;
    }

    @Override
    public ShopInfo queryObjectById(int id) {
        return null;
    }

    @Override
    public List<ShopInfo> queryList() {
        return null;
    }

    @Override
    public int queryTotalCount(ShopInfo shopInfo) {
        return this.getSqlSession().selectOne("ShopInfo.queryTotalCount",shopInfo);
    }

    @Override
    public List<ShopInfo> queryPage(BaseSearchPO<ShopInfo> baseSearchPO) {
        return this.getSqlSession().selectList("ShopInfo.queryPage",baseSearchPO);
    }

    @Override
    public int queryTotalCount(BaseSearchPO<ShopInfo> baseSearchPO) {
        return 0;
    }

    @Override
    public List<ShopInfo> queryListByIndex(String index) {
        return this.getSqlSession().selectList("ShopInfo.selectListByIndex",index);
    }

    @Override
    public ShopInfo queryShopCartByItemId(String itemId) {
        return null;
    }

    @Override
    public int addShopCartNumByItemId(String itemId) {
        return 0;
    }
}
