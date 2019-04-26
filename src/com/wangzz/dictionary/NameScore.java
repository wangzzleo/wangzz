package com.wangzz.dictionary;

import com.wangzz.http.HttpClientUtil;
import com.wangzz.xml.HTMLUtil;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NameScore {

    public static void main(String[] args) {
        File file = new File("C:\\\\Users\\\\user\\\\Desktop\\\\waterWords.txt");
        List<Character> words = new ArrayList<>();
        try(FileReader reader = new FileReader(file)) {
            while (reader.ready()) {
                char word = (char)reader.read();
                words.add(word);
            }
            for (Character word1: words) {
                for (Character word2: words) {
                    String name = String.valueOf(word1) + String.valueOf(word2);
                    String score = nameScoreTest("UTF-8", "application/x-www-form-urlencoded", name);
                    if (Integer.valueOf(score) > 90) {
                        System.out.println(name);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String nameScoreTest(String charset, String mimeType, String name) {
        List<BasicNameValuePair> testPairList = new ArrayList<>();
        testPairList.add(new BasicNameValuePair("xs","柴"));
        testPairList.add(new BasicNameValuePair("mz",name));
        testPairList.add(new BasicNameValuePair("action","test"));
        String nameScoreHTML = HttpClientUtil.sendPostSSLRequest("https://xmcs.buyiju.com/", null,testPairList, charset, mimeType);
        return HTMLUtil.getElementValueByClassWX(nameScoreHTML, "");
    }

}
