package com.sanske.springbootshiro.dao;

import com.sanske.springbootshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author sanske
 * @date 2018/8/6 上午11:19
 **/
@Mapper
public interface UserDao {
//    User getPassword(String username);
    String getPassword2(String username);
    String getRole(String username);
}
