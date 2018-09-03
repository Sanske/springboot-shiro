package com.sanske.springbootshiro.Controller;

import com.sanske.springbootshiro.common.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sanske
 * @date 2018/8/6 下午3:12
 **/

@RestController
@RequestMapping("/user")
public class User {
    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public Result getMessage() {
        return Result.success("您已经获得该用户的权限");
    }

}
