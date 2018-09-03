package com.sanske.springbootshiro.Controller;

import com.sanske.springbootshiro.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sanske
 * @date 2018/8/6 下午4:45
 **/
@RestController
@RequestMapping("/admin")
public class Admin {
    @RequestMapping(value="/getMessage", method = RequestMethod.GET)
    public Result getMessage() {
       return Result.success("您已经获得管理员的权限");
    }
}
