package net.sunmingchun.www.admin.role.po;

import java.util.Date;

/**
 * Created by smc on 2015/11/22.
 */
public class RoleResourcePO {

    private  String id;

    private String roleId;

    private String resourceId;

    private Date createTime;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
