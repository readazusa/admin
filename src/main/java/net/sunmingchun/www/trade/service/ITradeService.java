package net.sunmingchun.www.trade.service;

import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.service.IService;
import net.sunmingchun.www.trade.po.TradeInfo;

/**
 * Created by 念梓  on 2016/8/17.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
public interface ITradeService extends IService<TradeInfo> {

    public BasePagePO<TradeInfo> getBasePagePO(int pageIndex, int pageSize, TradeInfo tradeInfo, int draw);


    public BasePagePO<TradeInfo> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw);

}