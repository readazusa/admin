package net.sunmingchun.www.admin.log.dao;

import net.sunmingchun.www.admin.log.po.OperationLogPO;
import net.sunmingchun.www.admin.log.po.VisitLogPO;

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


}
