package net.sunmingchun.www.admin.resource.po;

import net.sunmingchun.www.base.po.BasePO;

/**
 * Created by smc on 2016/1/19.
 */
public class ResourcePO extends BasePO{

    private String  name;
    private String code;
    private int  exist = 1;   //是否该角色已经选中  0:选中 1:未选中
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }
}
