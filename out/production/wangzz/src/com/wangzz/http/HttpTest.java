package com.wangzz.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class HttpTest {
    public static void main(String[] args) {
        String url = "https://hanyu.baidu.com/hanyu/ajax/search_list?wd=%E4%BA%94%E8%A1%8C%E5%B1%9E%E6%B0%B4%E7%9A%84%E5%AD%97&from=poem&userid=238816338&pn=6&_=1555660507607";
        String body = "<?xml version=”1.0” encoding=”GBK” standalone=”yes”?>\n" +
                "<FOX>\n" +
                "</FOX>";
        String charset = "UTF-8";
        String mimeType = "application/x-www-form-urlencoded";
        List<BasicNameValuePair> pairList = new ArrayList<>();
//        pairList.add(new BasicNameValuePair("wd","五行属水的字"));
//        pairList.add(new BasicNameValuePair("from","poem"));
//        pairList.add(new BasicNameValuePair("userid","238816338"));
//        pairList.add(new BasicNameValuePair("pn","4"));
//        pairList.add(new BasicNameValuePair("_","1555659896268"));
        String s = HttpClientUtil.sendPostSSLRequest(url, pairList, charset, mimeType);
        JSONObject json = JSON.parseObject(s);
        json.entrySet().forEach(System.out::println);
        //System.out.println(s);

    }
}
