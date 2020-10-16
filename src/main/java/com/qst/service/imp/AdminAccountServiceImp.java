package com.qst.service.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qst.mapper.GoodsMapper;
import com.qst.mapper.OrdersMapper;
import com.qst.mapper.UserMapper;
import com.qst.pojo.*;
import com.qst.service.AdminAccountService;
import com.qst.util.MD5Utils;
import com.qst.util.TokenUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: XiPeng
 * @Description:
 * @Date: Create in 13:54 2020/10/12
 * @Modified by:
 */
@Service
public class AdminAccountServiceImp implements AdminAccountService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TokenUtils tokenUtils;
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    GoodsMapper goodsMapper;

    private static Logger logger = Logger.getLogger(UserAccountServiceImp.class);


    @Override
    public String selectStore(String token) {
        if ((!tokenUtils.getTokenStatic(token))||tokenUtils.getUser(token).getRole()==0){
            logger.info("登录失效，请重新登陆");
            return "flase";
        }
        tokenUtils.refresh(token);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria();
        List<Goods> list = goodsMapper.selectByExample(goodsExample);
        return JSON.toJSONString(list);
    }

    @Override
    public String updateStore(String token, String good_id, String store) {
        if ((!tokenUtils.getTokenStatic(token))||tokenUtils.getUser(token).getRole()==0){
            logger.info("登录失效，请重新登陆");
            return "flase";
        }
        tokenUtils.refresh(token);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodIdEqualTo(good_id);
        List<Goods> list = goodsMapper.selectByExample(goodsExample);
        Goods goods = new Goods();
        goods.setStore(Integer.valueOf(store));
        goods.setId(list.get(0).getId());
        int i = goodsMapper.updateByPrimaryKeySelective(goods);
        return JSON.toJSONString(i>0?true:false);
    }

    @Override
    public String login(User user) {
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
        if (use.getStatus()==0){
            logger.warn("用户已销户");
            return null;
        }
        if (!MD5Utils.getMD5(user.getPassword()).equals(use.getPassword())){
            logger.error("密码错误");
            return null;
        }
        if (use.getRole()!=1){
            logger.error("用户权限不足");
            return null;
        }
//        密码置空
        use.setPassword(null);
//        token计算并加入redis缓存
        String token = tokenUtils.addToken(use);
//        json转换
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token",token);
        jsonObject.put("user",use);
        return jsonObject.toString();
    }

    @Override
    public String getUserShow(String token) {
        if ((!tokenUtils.getTokenStatic(token))||tokenUtils.getUser(token).getRole()==0){
            logger.info("登录失效，请重新登陆");
            return "flase";
        }
        tokenUtils.refresh(token);
        UserExample userExample = new UserExample();
        userExample.createCriteria();
        List<User> list = userMapper.selectByExample(userExample);
        for (User user : list) {
            user.setPassword(null);
        }
        return JSON.toJSONString(list);
    }

    @Override
    public String updateUser(HashMap<String, String> map) {
        if ((!tokenUtils.getTokenStatic(map.get("token")))||tokenUtils.getUser(map.get("token")).getRole()==0){
            logger.info("登录失效，请重新登陆");
            return "false";
        }
        tokenUtils.refresh(map.get("token"));
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(map.get("userName"));
        List<User> list = userMapper.selectByExample(userExample);
        User user = list.get(0);
//        criteria.andIdEqualTo(user.getId());
        if (map.containsKey("password"))
            user.setPassword(map.get("password"));
        if (map.containsKey("status"))
            user.setStatus(Integer.valueOf(map.get("status")));
        if (map.containsKey("phone"))
            user.setPhone(map.get("phone"));
        if (map.containsKey("role"))
            user.setRole(Integer.valueOf(map.get("role")));

        int i = userMapper.updateByPrimaryKeySelective(user);
        return JSON.toJSONString(i>0?true:false);
    }

    @Override
    public String getOrder(String token) {
        if ((!tokenUtils.getTokenStatic(token))||tokenUtils.getUser(token).getRole()==0){
            logger.info("登录失效，请重新登陆");
            return "flase";
        }
        tokenUtils.refresh(token);
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria();
        List<Orders> list = ordersMapper.selectByExample(ordersExample);
        return JSON.toJSONString(list);
    }

    @Override
    public String delOrder(String token, String order_id) {
        if ((!tokenUtils.getTokenStatic(token))||tokenUtils.getUser(token).getRole()==0){
            logger.info("登录失效，请重新登陆");
            return "flase";
        }
        tokenUtils.refresh(token);
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderIdEqualTo(Integer.valueOf(order_id));
        int i = ordersMapper.deleteByExample(ordersExample);
        return JSON.toJSONString(i!=0?true:false);
    }


}
