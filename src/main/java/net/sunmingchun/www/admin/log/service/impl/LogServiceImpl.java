package net.sunmingchun.www.admin.log.service.impl;

import net.sunmingchun.www.admin.log.dao.ILogDao;
import net.sunmingchun.www.admin.log.po.OperationLogPO;
import net.sunmingchun.www.admin.log.po.VisitLogPO;
import net.sunmingchun.www.admin.log.service.ILogService;
import net.sunmingchun.www.base.po.BasePO;
import net.sunmingchun.www.base.service.IBaseTheadService;
import net.sunmingchun.www.util.UuidUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * net.sunmingchun.www.admin.log.service.impl
 * Created by smc
 * date on 2016/3/3.
 * Email:sunmch@163.com
 */
@Service(value = "logService")
public class LogServiceImpl implements ILogService,IBaseTheadService {

    @Resource
    private ILogDao logDao;

    @Override
    public void insertLog(BasePO basePO) {
        if (VisitLogPO.class.getName().equals(basePO.getClass().getName())) {

        } else {

        }
    }
    @Override
    public void execute(Object obj) {
        if (VisitLogPO.class.getName().equals(obj.getClass().getName())) {
            VisitLogPO visitLogPO = (VisitLogPO)obj;
            visitLogPO.setId(UuidUtils.getUpperUuid());
            visitLogPO.setCreateTime(new Date());
            visitLogPO.setUpdateTime(new Date());
            logDao.insertVisitPO(visitLogPO);
        } else {
            OperationLogPO operationLogPO = (OperationLogPO)obj;
            operationLogPO.setId(UuidUtils.getUpperUuid());
            operationLogPO.setUpdateTime(new Date());
            operationLogPO.setCreateTime(new Date());
            logDao.insertOperationPO(operationLogPO);
        }
    }

    @Override
    public void execute() {

    }
}


