package com.qst.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author: XiPeng
 * @Description:
 * @Date: Create in 12:08 2020/9/29
 * @Modified by:
 */
public class MD5 {
    public String getMD5(String text){
        return DigestUtils.md5Hex(text);
    }
    public String getMD5(String text,String key){
        return DigestUtils.md5Hex(text+key);
    }
}
