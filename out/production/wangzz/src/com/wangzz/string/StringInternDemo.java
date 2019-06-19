package com.wangzz.string;

import java.nio.charset.StandardCharsets;

/**
 * @author
 * @date
 */
public class StringInternDemo {

    public static void main(String[] args) {
//        String s = new String(new char[]{'a','b','c','d'},0,4);
//        //String srcs = "abcde";
//        //String s = new String(srcs);
//        String ss = s.intern();
//        //String s2 = "1";
//        System.out.println(s == ss);

        String s3 = new String("1") + new String("1");//编译器会优化成StringBuilder对象，不过不影响结果
        s3.intern();//将“11”字面量运行时期放到常量池中，JDK6和6以上版本区别体现在这儿，6会将“11”对象拷贝到
        String s4 = "11";//常量池已经有“11”，所以此处和s3相同
        System.out.println(s3 == s4);
    }

    public static String transfromOctalToString(String dataStr) {
        if (!dataStr.contains("\\")) {
            return dataStr;
        }
        //不属于八进制内容的字符
        StringBuilder oldBuffer = new StringBuilder();
        //属于八进制的内容，转成十六进制后缓存在这里
        StringBuilder hexBuffer = new StringBuilder();
        for (int i = 0; i < dataStr.length(); i++) {
            char c = dataStr.charAt(i);
            if (c != '\\') {
                oldBuffer.append(c);
            }
            //反斜杠往后3个为一组，组成了一个八进制数。例如\20710,其实是207组成了一个八进制数
            else {
                char c1 = dataStr.charAt(i + 1);
                char c2 = dataStr.charAt(i + 2);
                char c3 = dataStr.charAt(i + 3);
                i += 3;
                //将八进制转换为十进制，再转换为十六进制
                String hex = Integer.toHexString((Integer.valueOf("" + c1 + c2 + c3, 8)));
                //先缓存住，直到凑够三个字节
                hexBuffer.append(hex);
                String hexString = hexBuffer.toString();
                //utf8编码中，三个字节为一个汉字
                if (hexString.length() == 6) {
                    //凑够三个字节了，转成汉字后放入oldBuffer中
                    oldBuffer.append(hexStr2Str(hexString));
                    //凑够一个汉字了，清空缓存
                    hexBuffer = new StringBuilder();
                }
            }
        }
        return oldBuffer.toString();
    }

    /**
     * 十六进制转换字符串
     */
    private static String hexStr2Str(String hexStr) {
        String str = "0123456789abcdef";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
