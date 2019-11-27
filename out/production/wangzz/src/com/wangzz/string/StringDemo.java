package com.wangzz.string;

import com.wangzz.dictionary.Name;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author wangzz
 * @date
 */
public class StringDemo {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\Desktop\\bank.txt");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    String code = line.substring(line.length() - 3);
                    String newline = line.replace("123", code).substring(0, line.length() - 3);
                    System.out.println(newline);
                }

        } catch (Exception e) {
            System.err.println(e);
        }

    }

}
