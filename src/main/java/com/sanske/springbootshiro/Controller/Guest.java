package com.sanske.springbootshiro.Controller;

import com.sanske.springbootshiro.common.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sanske
 * @date 2018/8/6 下午2:24
 **/
@RestController
@RequestMapping("/guest")
public class Guest {

   @RequestMapping(value="/enter", method = RequestMethod.GET)
   public Result login() {
     return Result.success("您是游客");
   }

   @RequestMapping(value="/getMessage", method=RequestMethod.GET)
   public Result submitLogin() {
     return Result.success("您获得该权限");
   }
}
