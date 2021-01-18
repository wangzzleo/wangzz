package com.wangzz.md5;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author wangzz
 * @date
 */
public class MD5Test {

    public static void main(String[] args) throws Exception {
        String hash = "123";
        for (int i = 0; i < 10000; i++) {
            hash = hash(hash);
            System.out.println(hash);
        }
    }

    private static String hash(String str) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("SHA-256");
        byte[] digest = md5.digest(str.getBytes(StandardCharsets.UTF_8));
        StringBuilder result = new StringBuilder();
        for (byte b : digest) {
            result.append(Integer.toHexString((0x000000FF & b) | 0xFFFFFF00).substring(6));
        }
        return result.toString();
    }

}
