package net.sunmingchun.www.shiro.realm;

import net.sunmingchun.www.admin.resource.po.ResourcePO;
import net.sunmingchun.www.admin.role.po.RolePO;
import net.sunmingchun.www.admin.user.dao.IUserDao;
import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.shiro.dao.AuthorizationDao;
import net.sunmingchun.www.util.CodeConstantUtils;
import net.sunmingchun.www.util.DESUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.*;

/**
 * net.sunmingchun.www.shiro.realm
 * Created by smc
 * date on 2016/2/25.
 * Email:sunmch@163.com
 */
public class MyAuthorizationRealm extends AuthorizingRealm {

    @Resource
    private AuthorizationDao authorizationDao;

    /**
     * 给用户授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        UserPO userPO = (UserPO)principals.getPrimaryPrincipal();
        Map<String,Collection<String>> roleMap =getCollectionRoles(userPO.getId());
        simpleAuthorizationInfo.addRoles(roleMap.get("roleNames"));
        simpleAuthorizationInfo.addRoles(roleMap.get("roleCodes"));
        Map<String,Collection<String>> resMap = getCollectionRes(userPO.getId());
        simpleAuthorizationInfo.addStringPermissions(resMap.get("resNames"));
        simpleAuthorizationInfo.addStringPermissions(resMap.get("resCodes"));
        return simpleAuthorizationInfo;
    }

    private  Map<String,Collection<String>> getCollectionRoles(String userId) {
        Map<String,Collection<String>> targetRoleMap = new HashMap<>();
        List<RolePO> rolePOList = authorizationDao.queryAuthRolesByUserId(userId);
        List<String> roleCodes = new ArrayList<>(10);
        List<String> roleNames = new ArrayList<>(10);
        if(rolePOList != null && rolePOList.size()>0){
            for(RolePO rolePO : rolePOList){
                roleCodes.add(rolePO.getCode());
                roleNames.add(rolePO.getName());
            }
        }
        targetRoleMap.put("roleNames",roleNames);
        targetRoleMap.put("roleCodes",roleCodes);
        return targetRoleMap;
    }

    private Map<String,Collection<String>> getCollectionRes(String userId){
        List<ResourcePO> resourcePOList = authorizationDao.queryAuthResourcesByUserId(userId);
        Map<String,Collection<String>> targetResMap = new HashMap<>();
        List<String> resCodeList = new ArrayList<>(50);
        List<String> resNameList = new ArrayList<>(50);
        if(null != resourcePOList && resourcePOList.size()>0){
            for(ResourcePO resourcePO : resourcePOList){
                resCodeList.add(resourcePO.getCode());
                resNameList.add(resourcePO.getName());
            }
        }
        targetResMap.put("resNames",resNameList);
        targetResMap.put("resCodes",resCodeList);
        return targetResMap;
    }



    /**
     * 认证用户的真实性
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String password = new String(usernamePasswordToken.getPassword());
        String username = usernamePasswordToken.getUsername();
        Map<String, String> map = new HashMap<>();
        map.put("condition", username);
        map.put("password", DESUtils.encrypt(password));
        UserPO userPO = authorizationDao.getValidateUser(map);
        if (null == userPO) {
            throw new AuthenticationException("用户名或密码不正确");
        }
        setUserSession(userPO);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userPO, password, username);
        return simpleAuthenticationInfo;
    }

    private void setUserSession(UserPO userPO) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute(CodeConstantUtils.USER_INFO, userPO);
    }
}


