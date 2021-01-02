package com.wangzz.struct.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 题目描述：
 * 输入两行参数：
 *  参数1：8 3，总共8个整数，前3个升序，后面的降序
 *  参数2：1 5 4 2 7 9 4 1  8个整数
 *  相互之间用空格隔开
 *
 * 输出：1 4 5 9 7 4 2 1
 */
public class MixedSort {

    public static void main(String[] args) {
        try {
            int[][] ints = readParam();
            if (isValid(ints)) {
                assert ints != null;
                sort(ints[1], 0, ints[0][1], false);
                sort(ints[1], ints[0][1], ints[1].length, true);
                Arrays.stream(ints[1]).forEach(System.out::println);
            } else {
                System.out.println("执行异常");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] readParam() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int[][] ret = new int[2][];
            for (int i = 0; i < 2; i++) {
                String s = bufferedReader.readLine();
                if ("".equals(s) || s.length() <2) {
                    System.out.println("读取参数错误");
                    return null;
                }
                String[] strings = s.split(" ");
                int[] ints = new int[strings.length];
                for (int j = 0; j < strings.length; j++) {
                    ints[j] = Integer.parseInt(strings[j]);
                }
                ret[i] = ints;
            }
            return ret;
        }
    }

    public static boolean isValid(int[][] params) {
        if (params == null) {
            System.err.println("输入参数为空");
            return false;
        }
        if (params.length != 2) {
            System.err.println("参数大于两行");
            return false;
        }
        int[] param1 = params[0];
        if (param1.length != 2) {
            System.err.println("首行参数数量错误");
            return false;
        }
        int length = param1[0];
        int splitIndex = param1[1];
        if (splitIndex >= length) {
            System.err.println("数组长度小于切割位置");
            return false;
        }
        int[] param2 = params[1];
        if (param2.length != length) {
            System.err.println("数组实际长度与输入不符");
            return false;
        }
        return true;
    }

    public static void sort(int[] array, int start, int length, boolean isDesc) {
        for (int i = 0; i < length - start - 1; i++) {
            boolean notChanged = true;
            for (int j = start; j < length - 1 - i; j++) {
                if (isDesc) {
                    if (array[j] < array[j+1]) {
                        swap(array, j, j+1);
                        notChanged = false;
                    }
                } else {
                    if (array[j+1] < array[j]) {
                        swap(array, j, j+1);
                    }
                }
            }
            if (notChanged) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int src, int tgt) {
        int temp = arr[src];
        arr[src] = arr[tgt];
        arr[tgt] = temp;
    }
}
