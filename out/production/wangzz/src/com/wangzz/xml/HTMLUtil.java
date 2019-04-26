package com.wangzz.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class HTMLUtil {

    public static String getElementValueByName(String html, String name) {
        return null;
    }

    public static String getElementValueById(String html, String id) {
        return null;
    }

    public static String getElementValueByClassWX(String html, String className) {
        String res = "";
        try {
            Document document = Jsoup.parse(html);
            Elements wrappers = document.select(".wrapper");
            Element wrapper = wrappers.get(1);
            Elements viewbox = wrapper.select(".viewbox");
            Elements contents = viewbox.select(".content");
            Element content = contents.get(0);
            Elements p = content.select("p:contains(根据卜易居·名字测试打分，)");
            Element font = p.select("font").get(0);
            res = font.text();
        } catch (Exception e) {
            System.out.println(html);
        }
        return res;
    }

}
