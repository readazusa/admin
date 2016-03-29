package net.sunmingchun.www.shiro.realm;

import net.sunmingchun.www.admin.resource.po.ResourcePO;
import net.sunmingchun.www.admin.role.po.RolePO;
import net.sunmingchun.www.admin.user.dao.IUserDao;
import net.sunmingchun.www.admin.user.po.UserPO;
import net.sunmingchun.www.shiro.dao.AuthorizationDao;
import net.sunmingchun.www.shiro.token.MyUsernamePasswordToken;
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
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * net.sunmingchun.www.shiro.realm
 * Created by smc
 * date on 2016/2/25.
 * Email:sunmch@163.com
 */
public class MyAuthorizationRealm extends AuthorizingRealm {

    private static final String ROLE_KEY = "role_";

    private static final String RES_KEY = "res_";

    @Resource
    private AuthorizationDao authorizationDao;

    private Map<String, Collection<String>> userRolesMap = new HashMap<>();  //key表示方式:role_userid

    private Map<String, Collection<String>> userResMap = new HashMap<>();  //key表示: res_userid

    /**
     * 给用户授权
     * 这个方法只要页面上使用标签就会被调用一次
     * 好处：当某个用户权限或者角色发生变化的时候
     * 系统可以在不做任何改变的情况下，改变该用户的角色权限
     * 确定：每次都会调用数据库这样牵涉到的数据库交互比较多
     * 后期看情况修改，可以放在缓冲中,在每次登陆的时候修改权限
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        UserPO userPO = (UserPO) principals.getPrimaryPrincipal();
        if (userRolesMap.get(ROLE_KEY + userPO.getId()) == null) {
            insertRoleMap(userPO);
        }
        if (userResMap.get(RES_KEY + userPO.getId()) == null) {
            insertResMap(userPO);
        }
        if (null != userRolesMap.get(ROLE_KEY + userPO.getId())) {
            simpleAuthorizationInfo.addRoles(userRolesMap.get(ROLE_KEY + userPO.getId()));
        }
        if (null != userResMap.get(RES_KEY + userPO.getId())) {
            simpleAuthorizationInfo.addStringPermissions(userResMap.get(RES_KEY + userPO.getId()));
        }
        return simpleAuthorizationInfo;
    }

    private void insertRoleMap(UserPO userPO) {
        synchronized (userPO) {
            Map<String, Collection<String>> roleMap = getCollectionRoles(userPO.getId());
            Collection<String> collection = new ArrayList<>();
            collection.addAll(roleMap.get("roleNames"));
            collection.addAll(roleMap.get("roleCodes"));
            userRolesMap.put(ROLE_KEY + userPO.getId(), collection);
        }
    }

    private void insertResMap(UserPO userPO) {
        synchronized (userPO) {
            Map<String, Collection<String>> resMap = getCollectionRes(userPO.getId());
            Collection<String> collection = new ArrayList<>();
            collection.addAll(resMap.get("resNames"));
            collection.addAll(resMap.get("resCodes"));
            userResMap.put(RES_KEY + userPO.getId(), collection);
        }
    }

    private Map<String, Collection<String>> getCollectionRoles(String userId) {
        Map<String, Collection<String>> targetRoleMap = new HashMap<>();
        List<RolePO> rolePOList = authorizationDao.queryAuthRolesByUserId(userId);
        List<String> roleCodes = new ArrayList<>(10);
        List<String> roleNames = new ArrayList<>(10);
        if (rolePOList != null && rolePOList.size() > 0) {
            for (RolePO rolePO : rolePOList) {
                roleCodes.add(rolePO.getCode());
                roleNames.add(rolePO.getName());
            }
        }
        targetRoleMap.put("roleNames", roleNames);
        targetRoleMap.put("roleCodes", roleCodes);
        return targetRoleMap;
    }

    private Map<String, Collection<String>> getCollectionRes(String userId) {
        List<ResourcePO> resourcePOList = authorizationDao.queryAuthResourcesByUserId(userId);
        Map<String, Collection<String>> targetResMap = new HashMap<>();
        List<String> resCodeList = new ArrayList<>(50);
        List<String> resNameList = new ArrayList<>(50);
        if (null != resourcePOList && resourcePOList.size() > 0) {
            for (ResourcePO resourcePO : resourcePOList) {
                resCodeList.add(resourcePO.getCode());
                resNameList.add(resourcePO.getName());
            }
        }
        targetResMap.put("resNames", resNameList);
        targetResMap.put("resCodes", resCodeList);
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
        MyUsernamePasswordToken usernamePasswordToken = (MyUsernamePasswordToken) token;
        String password = new String(usernamePasswordToken.getPassword());
        String username = usernamePasswordToken.getUsername();
        String validatecode = usernamePasswordToken.getValidatecode();
        Session session = getSession();
        String sessionValidateCode = (String) session.getAttribute(CodeConstantUtils.VALIDATE_CODE);
        if (validatecode == null) {
            session.setAttribute("error", "验证码不能为空");
            throw new AuthenticationException("验证码不能为空");
        } else {
            if (!validatecode.equalsIgnoreCase(sessionValidateCode)) {
                session.setAttribute("error", "您输入的验证码不正确");
                throw new AuthenticationException("验证码不能为空");
            }
        }
        Map<String, String> map = new HashMap<>();
        map.put("condition", username);
        map.put("password", DESUtils.encrypt(password));
        UserPO userPO = authorizationDao.getValidateUser(map);
        if (null == userPO) {
            session.setAttribute("error", "用户名或密码不正确");
            throw new AuthenticationException("用户名或密码不正确");
        }
        userResMap.remove(RES_KEY + userPO.getId());
        userRolesMap.remove(ROLE_KEY + userPO.getId());
        setUserSession(userPO);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userPO, password, username);
        return simpleAuthenticationInfo;
    }

    private void setUserSession(UserPO userPO) {
        Session session = getSession();
        session.setAttribute(CodeConstantUtils.USER_INFO, userPO);
    }

    public Session getSession() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        return session;
    }
}


