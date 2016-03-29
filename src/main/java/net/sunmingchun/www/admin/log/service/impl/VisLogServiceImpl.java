package net.sunmingchun.www.admin.log.service.impl;

import net.sunmingchun.www.admin.log.dao.ILogDao;
import net.sunmingchun.www.admin.log.po.VisitLogPO;
import net.sunmingchun.www.admin.log.service.IVisLogService;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.base.po.BaseSearchPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * net.sunmingchun.www.admin.log.service.impl
 * Created by smc
 * date on 2016/3/28.
 * Email:sunmch@163.com
 */
@Service
public class VisLogServiceImpl implements IVisLogService {

    @Resource
    private ILogDao logDao;

    @Override
    public BasePagePO<VisitLogPO> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw) {

        VisitLogPO visitLogPO = new VisitLogPO();
        visitLogPO.setSearch(searchValue);
        BaseSearchPO<VisitLogPO> baseSearchPO = new BaseSearchPO<>();
        baseSearchPO.setObj(visitLogPO);
        baseSearchPO.setPageSize(pageSize);
        baseSearchPO.setPageIndex(pageIndex);
        baseSearchPO.setOrderName(orderColumn);
        baseSearchPO.setOrderValue(orderValue);
        /*
         *上面是构造查询条件
         *
         * 下面是返回查询结构
         */
        List<VisitLogPO> visitLogPOList = logDao.queryVisPage(baseSearchPO);
        int totalCount = this.getTotalCount(visitLogPO);
        BasePagePO<VisitLogPO> basePagePO = new BasePagePO<>();
        basePagePO.setData(visitLogPOList);
        basePagePO.setDraw(draw);
        basePagePO.setRecordsTotal(totalCount);
        basePagePO.setRecordsFiltered(totalCount);
        return basePagePO;
    }

    @Override
    public VisitLogPO queryObjectById(String id) {
        return logDao.queryVisObjectById(id);
    }

    @Override
    public VisitLogPO queryObjectById(int id) {
        return null;
    }

    @Override
    public List<VisitLogPO> queryList() {
        return null;
    }

    @Override
    public void save(VisitLogPO obj) {

    }

    @Override
    public void deleteById(String uid) {

    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(VisitLogPO visitLogPO) {

    }

    @Override
    public int getTotalCount(VisitLogPO visitLogPO) {
        return logDao.queryVisTotalCount(visitLogPO);
    }

    @Override
    public BasePagePO<VisitLogPO> getBasePagePO(int pageIndex, int pageSize, VisitLogPO visitLogPO) {
        return null;
    }

    @Override
    public List<VisitLogPO> queryListPO(int pageIndex, int pageSize, VisitLogPO visitLogPO) {
        return null;
    }
}
