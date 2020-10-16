package com.qst.service;

import com.qst.pojo.User;

import java.util.HashMap;

/**
 * @Author: XiPeng
 * @Description:
 * @Date: Create in 13:54 2020/10/12
 * @Modified by:
 */
public interface AdminAccountService {
    String login(User user);

    String getUserShow(String token);

    String updateUser(HashMap<String, String> map);

    String getOrder(String token);

    String delOrder(String token, String order_id);

    String selectStore(String token);

    String updateStore(String token, String good_id, String store);
}
