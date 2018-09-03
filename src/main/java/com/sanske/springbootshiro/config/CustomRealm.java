package com.sanske.springbootshiro.config;

import com.sanske.springbootshiro.dao.UserDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sanske
 * @date 2018/8/6 上午10:58
 **/
public class CustomRealm extends AuthorizingRealm {
  @Autowired
  private UserDao userDao;

  /**
   *
   * @param authenticationToken
   * @return
   * @throws AuthenticationException
   * 从数据库中查 是否符合认证的信息
   */
  @Override
  public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    String password = userDao.getPassword2(token.getUsername());
    if(null == password) {
      throw new AccountException("用户名不正确");
    } else if(!password.equals(new String((char[])token.getCredentials()))) {
      throw new AccountException("密码不正确");
    };

    return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
  }

  /**
   * @param principalCollection
   * @return
   * 获取符合条件的的用户，重定向
   */
  @Override
  public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    String username = (String) SecurityUtils.getSubject().getPrincipal();
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    String role = userDao.getRole(username);
    Set<String> set = new HashSet();
    set.add(role);
    info.setRoles(set);
    return info;
  }

}
