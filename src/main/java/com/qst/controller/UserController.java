package com.qst.controller;

import com.qst.pojo.User;
import com.qst.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam(value = "loginName") String userName,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "userName") String roleName,
                           @RequestParam(value = "phone") String phone){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setRealname(roleName);
        user.setPhone(phone);


        return "";
    }


}
