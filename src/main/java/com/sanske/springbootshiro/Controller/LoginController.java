package com.sanske.springbootshiro.Controller;

import com.sanske.springbootshiro.common.result.Result;
import com.sanske.springbootshiro.dao.UserDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sanske
 * @date 2018/8/6 下午4:50
 **/

@RestController
public class LoginController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public Result notLogin() {
        return Result.success("您尚未登录");
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public Result notRle() {
       return Result.success("您没有权限！");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return Result.success("成功注销！");
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Result login(String username, String password) {
      Subject subject = SecurityUtils.getSubject();
      //认证之前获取 token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        System.out.println("token:" + token);
        subject.login(token);
        String role = userDao.getRole(username);
        if("user".equals(role)) {
          return Result.success("欢迎用户登录");
        }
        if("admin".equals(role)) {
            return Result.success("欢迎管理员登陆！");
        }

        return Result.fail("抱歉， 您没有访问权限！");
    }
}
