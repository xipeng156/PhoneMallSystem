package com.qst.service.imp;

import com.qst.mapper.UserMapper;
import com.qst.pojo.User;
import com.qst.pojo.UserExample;
import com.qst.service.UserService;
import com.qst.util.MD5;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private static Logger logger = Logger.getLogger(UserServiceImp.class);

    /**
     * 用户注册
     * @param user
     * @return
     */
    public int register(User user) {
//        密码加密
        user.setPassword(MD5.getMD5(user.getPassword()));
//        检查数据库中是否存在重复用户名
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size()>0){
            logger.error("用户名重复，换一个试试吧");
            return 0;
        }
        return userMapper.insert(user);
    }

    @Override
    public User login(User user) {
//        查询数据库信息
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> list = userMapper.selectByExample(userExample);
//        返回数据处理
        if (list.size()>1){
            logger.error("列表里有多个重复的用户名信息,登录失败");
            return null;
        }else if (list.size()==0){
            logger.error("用户名不存在");
            return null;
        }
        User use = list.get(0);
        if (!MD5.getMD5(user.getPassword()).equals(use.getPassword())){
            logger.error("密码错误");
            return null;
        }
        return use;
    }


}
