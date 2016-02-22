package net.sunmingchun.www.admin.user.po;

import java.util.Date;

/**
 * Created by smc on 2015/11/23.
 */
public class UserRolePO {
    private String id;

    private String userId;

    private String roleId;

    private Date createTime;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
