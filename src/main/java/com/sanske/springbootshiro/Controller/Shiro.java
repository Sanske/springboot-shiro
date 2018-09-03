package com.sanske.springbootshiro.Controller;

import com.sanske.springbootshiro.dao.UserDao;
import com.sanske.springbootshiro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sanske
 * @date 2018/8/3 上午11:15
 **/
@RestController
public class Shiro {
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String helloGet(String name) {
        return "hi, " + name;

    }

    @RequestMapping(value = "/getPassword", method = RequestMethod.GET)
    public String getPassord(String username) {
//       User user = userDao.getPassword(username);
//       System.out.println("user:" + user);
        String password = userDao.getPassword2(username);
        System.out.println("password: " + password);
        return "测试";
    }
}
