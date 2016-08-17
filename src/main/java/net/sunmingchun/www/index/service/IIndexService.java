package net.sunmingchun.www.index.service;

import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.service.IService;
import net.sunmingchun.www.index.po.IndexPageInfo;

/**
 * Created by 念梓  on 2016/8/17.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
public interface  IIndexService  extends IService<IndexPageInfo> {

    public BasePagePO<IndexPageInfo> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw,String type);

}
