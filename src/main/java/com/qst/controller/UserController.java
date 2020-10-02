package com.qst.controller;

import com.alibaba.fastjson.JSON;
import com.qst.enums.UserStatus;
import com.qst.pojo.User;
import com.qst.service.UserService;
import com.qst.util.Constants;
import com.qst.util.MD5;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: XiPeng
 * @Description:
 * @Date: Create in 17:58 2020/9/29
 * @Modified by:
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(HttpSession session,
                           @RequestParam(value = "loginName",required = false) String userName,
                           @RequestParam(value = "password",required = false) String password,
                           @RequestParam(value = "userName",required = false) String roleName,
                           @RequestParam(value = "phone",required = false) String phone){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setRealname(roleName);
        user.setPhone(phone);
        int register = userService.register(user);
        if (register==1){
            session.setAttribute(Constants.REGISTER_STATIC_SESSION,JSON.toJSONString(UserStatus.REGISTER_SUCCESS));
        }
        else {
            session.setAttribute(Constants.REGISTER_STATIC_SESSION,JSON.toJSONString(UserStatus.REGISTER_FAIL));
        }
//        跳转到登录页
        return "denglu";
    }

    @RequestMapping(value = "/denglu",method = RequestMethod.POST)
    public String denglu(HttpSession session,
            @RequestParam(value = "loginName") String userName,
                         @RequestParam(value = "password") String password){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        User login = userService.login(user);
        login.setPassword(null);
//        判断角色:前端处理
        session.setAttribute(Constants.USER_SESSION,JSON.toJSON(login));
        return "home";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(Constants.USER_SESSION);
        return "denglu";
    }

}
