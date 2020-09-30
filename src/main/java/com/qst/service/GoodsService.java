package com.qst.service;

import com.qst.pojo.Goods;

import java.util.List;

/**
 * @Author: XiPeng
 * @Description:
 * @Date: Create in 14:30 2020/9/30
 * @Modified by:
 */
public interface GoodsService {
    List<Goods> getGoodList();
    List<Goods> getGoodList(String name);

    int addGoods(Goods goods);

    int deleteGoods(int good_id);

    int UpdateGoods(Goods goods);

}
