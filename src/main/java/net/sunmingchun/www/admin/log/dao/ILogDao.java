package net.sunmingchun.www.admin.log.dao;

import net.sunmingchun.www.admin.log.po.OperationLogPO;
import net.sunmingchun.www.admin.log.po.VisitLogPO;
import net.sunmingchun.www.base.po.BaseSearchPO;

import java.util.List;

/**
 * net.sunmingchun.www.admin.log.dao
 * Created by smc
 * date on 2016/3/3.
 * Email:sunmch@163.com
 * 日志dao
 */
public interface ILogDao {


    /**
     * 保存访问日志
     * @param visitLogPO
     */
    public void insertVisitPO(VisitLogPO visitLogPO);

    /**
     * 保存操作日志
     * @param operationLogPO
     */
    public void insertOperationPO(OperationLogPO operationLogPO);

    public List<VisitLogPO> queryVisPage(BaseSearchPO<VisitLogPO> baseSearchPO);   //获取分页的数据数

    public List<OperationLogPO> queryOperPage(BaseSearchPO<OperationLogPO> baseSearchPO);   //获取分页的数据数

    public int queryVisTotalCount(VisitLogPO visitLogPO);

    public int queryOperoTotalCount(OperationLogPO operationLogPO);

    public VisitLogPO  queryVisObjectById(String id);

    public OperationLogPO  queryOperObjectById(String id);



}
