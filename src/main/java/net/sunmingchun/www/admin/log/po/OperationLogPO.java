package net.sunmingchun.www.admin.log.po;

import net.sunmingchun.www.base.po.BasePO;

/**
 * net.sunmingchun.www.admin.log.po
 * Created by smc
 * date on 2016/3/3.
 * Email:sunmch@163.com
 */
public class OperationLogPO extends VisitLogPO{

    private String name;  //操作人名称

    private String operationName;   //操作名称

   public OperationLogPO(){

   }

   public OperationLogPO(String userAgent,String userIp,String adddress,String url,String method,String name,String operationName) {
       super(userAgent,userIp,adddress,url,method);
       this.name = name;
       this.operationName = operationName;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}
