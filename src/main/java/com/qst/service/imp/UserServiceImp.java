package com.qst.service.imp;

import com.qst.mapper.UserMapper;
import com.qst.pojo.User;
import com.qst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: XiPeng
 * @Description:
 * @Date: Create in 17:51 2020/9/29
 * @Modified by:
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;

    public int register(User user) {
        return userMapper.insert(user);
    }
}
