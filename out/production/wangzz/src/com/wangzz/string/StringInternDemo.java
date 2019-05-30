package com.wangzz.string;

/**
 * @author wangzz
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

}
