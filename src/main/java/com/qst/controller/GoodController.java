package com.qst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: XiPeng
 * @Description:
 * @Date: Create in 14:28 2020/9/30
 * @Modified by:
 */
@Controller
public class GoodController {
    @RequestMapping("/goodList")
    public String getGoodList(){

        return "";
    }
}
