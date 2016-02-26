package net.sunmingchun.www.shiro.realm;

import net.sunmingchun.www.shiro.token.MyUsernamePasswordToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * net.sunmingchun.www.shiro.realm
 * Created by smc
 * date on 2016/2/25.
 * Email:sunmch@163.com
 */
public class MyAuthorizationRealm extends AuthorizingRealm {

    /**
     * 给用户授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        principals.
        return null;
    }

    /**
     * 认证用户的真实性
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        MyUsernamePasswordToken myUsernamePasswordToken = (MyUsernamePasswordToken)token;

        return null;
    }
}
