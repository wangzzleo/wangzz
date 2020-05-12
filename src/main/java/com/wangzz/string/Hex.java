package com.wangzz.string;

import org.omg.CosNaming.BindingIterator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author wangzz
 * @date
 */
public class Hex {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for(byte b : data) {
            if (n % 16 == 0) {
                result.append(String.format("%05X: ", n));
            }
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) {
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\Java\\StringInternDemo.class");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fileInputStream.read(bytes);
        String format = format(bytes);
        System.out.println(format);
    }

}
