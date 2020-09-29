package com.qst.controller;

import com.alibaba.fastjson.JSON;
import com.qst.enums.UserStatus;
import com.qst.pojo.User;
import com.qst.service.UserService;
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
            session.setAttribute("status",JSON.toJSONString(UserStatus.REGISTER_SUCCESS));
        }
        else {
            session.setAttribute("status",JSON.toJSONString(UserStatus.REGISTER_FAIL));
        }

        return "";
    }


}
