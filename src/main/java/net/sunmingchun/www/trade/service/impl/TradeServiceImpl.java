package net.sunmingchun.www.trade.service.impl;

import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.trade.dao.ITradeDao;
import net.sunmingchun.www.trade.po.OrderInfo;
import net.sunmingchun.www.trade.po.TradeInfo;
import net.sunmingchun.www.trade.service.ITradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 念梓  on 2016/8/17.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Service
public class TradeServiceImpl implements ITradeService {


    @Resource
    private ITradeDao tradeDao;


    @Override
    public TradeInfo queryObjectById(String id) {
        TradeInfo  tradeInfo = tradeDao.queryObjectById(id);
        if(tradeInfo != null){
            List<OrderInfo> orderInfos = tradeDao.queryOrderListByTradeId(id);
            tradeInfo.setOrderInfoList(orderInfos);
        }
        return tradeInfo;
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
        this.tradeDao.update(tradeInfo);
    }

    @Override
    public int getTotalCount(TradeInfo tradeInfo) {
        return this.tradeDao.queryTotalCount(tradeInfo);
    }

    @Override
    public BasePagePO<TradeInfo> getBasePagePO(int pageIndex, int pageSize, TradeInfo tradeInfo) {
        return null;
    }

    @Override
    public List<TradeInfo> queryListPO(int pageIndex, int pageSize, TradeInfo tradeInfo) {
        return null;
    }

    @Override
    public BasePagePO<TradeInfo> getBasePagePO(int pageIndex, int pageSize, TradeInfo tradeInfo, int draw) {
        return null;
    }

    @Override
    public BasePagePO<TradeInfo> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw) {
        BaseSearchPO<TradeInfo> baseSearchPO = new BaseSearchPO<>();
        baseSearchPO.setPageIndex(pageIndex);
        baseSearchPO.setPageSize(pageSize);
        baseSearchPO.setOrderName(orderColumn);
        baseSearchPO.setOrderValue(orderValue);
        TradeInfo tradeInfo = new TradeInfo();
        baseSearchPO.setObj(tradeInfo);

        int totalCount = this.tradeDao.queryTotalCount(tradeInfo);
        List<TradeInfo> tradeInfoList = this.tradeDao.queryPage(baseSearchPO);
        BasePagePO<TradeInfo> basePagePO = new BasePagePO<>();
        basePagePO.setRecordsTotal(totalCount);
        basePagePO.setData(tradeInfoList);
        basePagePO.setDraw(draw);
        basePagePO.setRecordsFiltered(totalCount);
        return basePagePO;
    }
}
