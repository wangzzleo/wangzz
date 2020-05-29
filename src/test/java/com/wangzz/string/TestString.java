package com.wangzz.string;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class TestString {

    @Test
    public void testString() {
        String str = "a";//"{\"ReplyCode\":\"aaaa\", \"ReplyMsg\":\"aaaa\"}";
        System.out.println("str="+str);
        String s = JSON.toJSONString(str);
        System.out.println("s  ="+s);
    }

}
