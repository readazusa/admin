package net.sunmingchun.www.trade.dao.impl;

import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.trade.dao.ITradeDao;
import net.sunmingchun.www.trade.po.OrderInfo;
import net.sunmingchun.www.trade.po.TradeInfo;
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
public class TradeDaoImpl extends SqlSessionDaoSupport implements ITradeDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void save(TradeInfo obj) {

    }

    @Override
    public void deleteById(String uid) {

    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(TradeInfo tradeInfo) {
        this.getSqlSession().update("TradeInfo.update",tradeInfo);
    }

    @Override
    public TradeInfo queryObjectById(String id) {
        List<TradeInfo> tradeInfos = this.getSqlSession().selectList("TradeInfo.select",id);
        return tradeInfos.size()>0?tradeInfos.get(0):null;
    }

    @Override
    public TradeInfo queryObjectById(int id) {
        return null;
    }

    @Override
    public List<TradeInfo> queryList() {
        return null;
    }

    @Override
    public int queryTotalCount(TradeInfo tradeInfo) {
        return this.getSqlSession().selectOne("TradeInfo.queryTotalCount",tradeInfo);
    }

    @Override
    public List<TradeInfo> queryPage(BaseSearchPO<TradeInfo> baseSearchPO) {

        return this.getSqlSession().selectList("TradeInfo.queryPage",baseSearchPO);
    }

    @Override
    public int queryTotalCount(BaseSearchPO<TradeInfo> baseSearchPO) {
        return 0;
    }

    @Override
    public List<OrderInfo> queryOrderListByTradeId(String tradeId) {
        return this.getSqlSession().selectList("TradeInfo.queryOrderListByTradeId",tradeId);
    }

    @Override
    public int updateOrder(OrderInfo orderInfo) {
        return this.getSqlSession().update("TradeInfo.updateOrder",orderInfo);
    }
}
