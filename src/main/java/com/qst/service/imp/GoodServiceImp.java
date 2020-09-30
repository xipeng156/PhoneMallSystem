package com.qst.service.imp;

import com.qst.mapper.GoodsMapper;
import com.qst.pojo.Goods;
import com.qst.pojo.GoodsExample;
import com.qst.service.GoodsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: XiPeng
 * @Description:
 * @Date: Create in 14:31 2020/9/30
 * @Modified by:
 */
public class GoodServiceImp implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    private static org.apache.log4j.Logger logger = Logger.getLogger(UserServiceImp.class);


    /**
     * 获取商品列表
     * @return
     */
    @Override
    public List<Goods> getGoodList() {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();

        List<Goods> list = goodsMapper.selectByExample(goodsExample);
        if (list.size()==0) {
            logger.warn("数据库中没有goods数据");
            return null;
        }
        return list;
    }

    /**
     * 根据名称获取商品列表（模糊查询）
     * @param name 商品名
     * @return
     */
    public List<Goods> getGoodList(String name) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andNameLike(name);
        List<Goods> list = goodsMapper.selectByExample(goodsExample);
        if (list.size()==0) {
            logger.warn("数据库中没有关于" + name + "的数据");
            return null;
        }
        return list;
    }

    @Override
    public int addGoods(Goods goods) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodIdEqualTo(goods.getGoodId());
        List<Goods> list = goodsMapper.selectByExample(goodsExample);
        if (list.size()>0){
            logger.error("抱歉，商品ID重复，请更换商品id");
            return 0;
        }
        return goodsMapper.insert(goods);
    }

    @Override
    public int deleteGoods(int good_id) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodIdEqualTo(good_id);
        return goodsMapper.deleteByExample(goodsExample);
    }

    @Override
    public int UpdateGoods(Goods goods) {
        return 0;
    }


}
