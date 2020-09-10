package com.wangzz.string;

public class ByteToStringDemo {

    public static void main(String[] args) {
        byte[] bytes = new byte[]{98,108,111,103,49,50,51,49,50,51};
        String s = new String(bytes);
        System.out.println(s);
    }

}
