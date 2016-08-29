package net.sunmingchun.www.shopcart.dao.impl;

import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.shopcart.dao.IShopCartDao;
import net.sunmingchun.www.shopcart.po.ShopCartInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 念梓  on 2016/8/25.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Repository
public class ShopCartDaoImpl extends SqlSessionDaoSupport implements IShopCartDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void save(ShopCartInfo obj) {
        this.getSqlSession().insert("ShopCartInfo.save",obj);
    }

    @Override
    public void deleteById(String uid) {

    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(ShopCartInfo shopCartInfo) {

    }

    @Override
    public ShopCartInfo queryObjectById(String id) {
        return null;
    }

    @Override
    public ShopCartInfo queryObjectById(int id) {
        return null;
    }

    @Override
    public List<ShopCartInfo> queryList() {
        return null;
    }

    @Override
    public int queryTotalCount(ShopCartInfo shopCartInfo) {
        return 0;
    }

    @Override
    public List<ShopCartInfo> queryPage(BaseSearchPO<ShopCartInfo> baseSearchPO) {
        return null;
    }

    @Override
    public int queryTotalCount(BaseSearchPO<ShopCartInfo> baseSearchPO) {
        return 0;
    }

    @Override
    public ShopCartInfo queryShopCartByItemId(ShopCartInfo shopCartInfo) {
        List<ShopCartInfo> shopCartInfos = this.getSqlSession().selectList("ShopCartInfo.queryShopCartByItemId",shopCartInfo);
        return shopCartInfos.size()>0?shopCartInfos.get(0):null;
    }

    @Override
    public int addShopCartNumByItemId(ShopCartInfo shopCartInfo) {
        return this.getSqlSession().insert("ShopCartInfo.addShopCartNumByItemId",shopCartInfo);
    }



}
