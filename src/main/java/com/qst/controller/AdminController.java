package com.qst.controller;

import com.alibaba.fastjson.JSON;
import com.qst.pojo.User;
import com.qst.service.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author: XiPeng
 * @Description:
 * @Date: Create in 13:49 2020/10/12
 * @Modified by:
 */
@Controller
public class AdminController {
    @Autowired
    AdminAccountService adminAccountService;

    //管理员登录
    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
    @ResponseBody
    public String adminLogin(
            @RequestParam(value = "loginName") String userName,
            @RequestParam(value = "password") String password){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        String login = adminAccountService.login(user);
        return login;
    }

    //用户信息遍历
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ResponseBody
    public String getUserShow(@RequestHeader(value = "token")String token){
        return adminAccountService.getUserShow(token);
    }

    //用户信息修改
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@RequestHeader(value = "token")String token,
                             @RequestParam(value = "userName")String userName,
                             @RequestParam(value = "status",required = false)String status,
                             @RequestParam(value = "phone",required = false)String phone,
                             @RequestParam(value = "role",required = false)String role
                             ){
        HashMap<String, String> map = new HashMap<>();
        map.put("token",token);
        if (userName!=null)
            map.put("userName",userName);
        if (status!=null)
            map.put("Status",status);
        if (phone!=null)
            map.put("phone",phone);
        if (role!=null)
            map.put("role",role);
        String user = adminAccountService.updateUser(map);
        return user;
    }

    @RequestMapping(value = "/adminGetOrderList",method = RequestMethod.POST)
    @ResponseBody
    public String getOrder(@RequestHeader(value = "token")String token){
        return adminAccountService.getOrder(token);
    }

    @RequestMapping(value = "/delOrder",method = RequestMethod.POST)
    @ResponseBody
    public String delOrder(@RequestHeader(value = "token")String token,
                           @RequestParam(value = "order_id")String order_id){
        return adminAccountService.delOrder(token,order_id);
    }

    @RequestMapping(value = "/selectStore",method = RequestMethod.POST)
    @ResponseBody
    public String selectStore(@RequestHeader(value = "token")String token){
        return adminAccountService.selectStore(token);
    }

    @RequestMapping(value = "/updateStore",method = RequestMethod.POST)
    @ResponseBody
    public String updateStore(
            @RequestHeader(value = "token")String token,
            @RequestParam(value = "good_id")String good_id,
            @RequestParam(value = "store")String store
    ){
        return adminAccountService.updateStore(token,good_id,store);
    }
}