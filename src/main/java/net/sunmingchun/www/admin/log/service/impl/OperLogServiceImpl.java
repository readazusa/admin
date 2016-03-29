package net.sunmingchun.www.admin.log.service.impl;

import net.sunmingchun.www.admin.log.dao.ILogDao;
import net.sunmingchun.www.admin.log.po.OperationLogPO;
import net.sunmingchun.www.admin.log.po.VisitLogPO;
import net.sunmingchun.www.admin.log.service.IOperLogService;
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
public class OperLogServiceImpl implements IOperLogService {

    @Resource
    private ILogDao logDao;
    @Override
    public BasePagePO<OperationLogPO> getBasePagePO(int pageIndex, int pageSize, String searchValue, String orderColumn, String orderValue, int draw) {

        OperationLogPO operationLogPO = new OperationLogPO();
        operationLogPO.setSearch(searchValue);
        BaseSearchPO<OperationLogPO> baseSearchPO = new BaseSearchPO<>();
        baseSearchPO.setObj(operationLogPO);
        baseSearchPO.setPageSize(pageSize);
        baseSearchPO.setPageIndex(pageIndex);
        baseSearchPO.setOrderName(orderColumn);
        baseSearchPO.setOrderValue(orderValue);
        /*
         *上面是构造查询条件
         *
         * 下面是返回查询结构
         */
        List<OperationLogPO> operationLogPOList = logDao.queryOperPage(baseSearchPO);
        int totalCount = this.getTotalCount(operationLogPO);
        BasePagePO<OperationLogPO> basePagePO = new BasePagePO<>();
        basePagePO.setData(operationLogPOList);
        basePagePO.setDraw(draw);
        basePagePO.setRecordsTotal(totalCount);
        basePagePO.setRecordsFiltered(totalCount);
        return basePagePO;
    }

    @Override
    public OperationLogPO queryObjectById(String id) {
        return null;
    }

    @Override
    public OperationLogPO queryObjectById(int id) {
        return null;
    }

    @Override
    public List<OperationLogPO> queryList() {
        return null;
    }

    @Override
    public void save(OperationLogPO obj) {

    }

    @Override
    public void deleteById(String uid) {

    }

    @Override
    public void deleteById(int uid) {

    }

    @Override
    public void update(OperationLogPO operationLogPO) {

    }

    @Override
    public int getTotalCount(OperationLogPO operationLogPO) {
        return logDao.queryOperoTotalCount(operationLogPO);
    }

    @Override
    public BasePagePO<OperationLogPO> getBasePagePO(int pageIndex, int pageSize, OperationLogPO operationLogPO) {
        return null;
    }

    @Override
    public List<OperationLogPO> queryListPO(int pageIndex, int pageSize, OperationLogPO operationLogPO) {
        return null;
    }
}
