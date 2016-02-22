package net.sunmingchun.www.admin.role.po;

import net.sunmingchun.base.po.BasePO;

/**
 * Created by smc on 2015/11/22.
 */
public class RolePO extends BasePO{

    private String code;

    private String name;

    private int exist =1;   //是否该角色已经选中  0:选中 1:未选中

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }
}
