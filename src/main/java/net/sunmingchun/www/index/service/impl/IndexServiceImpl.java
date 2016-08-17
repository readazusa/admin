package net.sunmingchun.www.index.service.impl;

import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import net.sunmingchun.www.index.dao.IIndexDao;
import net.sunmingchun.www.index.po.IndexPageInfo;
import net.sunmingchun.www.index.service.IIndexService;
import net.sunmingchun.www.util.UuidUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 念梓  on 2016/8/17.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Service
public class IndexServiceImpl implements IIndexService {

    @Resource
    private IIndexDao indexDao;

    @Override
    public BasePagePO<IndexPageInfo> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw,String type) {

        BaseSearchPO<IndexPageInfo> baseSearchPO = new BaseSearchPO<>();
        IndexPageInfo indexPageInfo = new IndexPageInfo();
        indexPageInfo.setType(type);
        baseSearchPO.setObj(indexPageInfo);
        baseSearchPO.setOrderName(orderColumn);
        baseSearchPO.setOrderValue(orderValue);
        baseSearchPO.setPageSize(pageSize);
        baseSearchPO.setPageIndex(pageIndex);
        int totalCount = indexDao.queryTotalCount(indexPageInfo);
        List<IndexPageInfo> indexPageInfoList = indexDao.queryPage(baseSearchPO);
        BasePagePO<IndexPageInfo> basePagePO = new BasePagePO<>();
        basePagePO.setRecordsFiltered(totalCount);
        basePagePO.setDraw(draw);
        basePagePO.setData(indexPageInfoList);
        basePagePO.setRecordsTotal(totalCount);
        return basePagePO;
    }

    @Override
    public IndexPageInfo queryObjectById(String id) {

        return indexDao.queryObjectById(id);
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
    public void save(IndexPageInfo obj) {
        obj.setUpdateTime(new Date());
        obj.setCreateTime(new Date());
        obj.setId(UuidUtils.getUpperUuid());
        indexDao.save(obj);

    }

    @Override
    public void deleteById(String uid) {
        indexDao.deleteById(uid);
    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(IndexPageInfo indexPageInfo) {
        indexDao.update(indexPageInfo);
    }

    @Override
    public int getTotalCount(IndexPageInfo indexPageInfo) {
        return 0;
    }

    @Override
    public BasePagePO<IndexPageInfo> getBasePagePO(int pageIndex, int pageSize, IndexPageInfo indexPageInfo) {
        return null;
    }

    @Override
    public List<IndexPageInfo> queryListPO(int pageIndex, int pageSize, IndexPageInfo indexPageInfo) {
        return null;
    }
}
