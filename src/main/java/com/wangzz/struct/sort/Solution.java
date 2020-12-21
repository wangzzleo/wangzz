package com.wangzz.struct.sort;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    public static void insertSort(int[] numbers) {
        if (numbers == null) {
            return;
        }
        Arrays.stream(numbers).forEach(value -> System.out.print(value +" "));
        System.out.println();
        for (int i = 1; i < numbers.length; i++) {
            int temp = numbers[i];
            int pit = i;
            while (pit > 0 && temp < numbers[pit - 1]) {
                numbers[pit] = numbers[pit - 1];
                pit--;
            }
            numbers[pit] = temp;
            Arrays.stream(numbers).forEach(value -> System.out.print(value +" "));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        long sum = 0;
        for (int c = 0; c<100; c++) {
            int[] a = new int[10000];
            Random random = new Random();
            for (int i = 0; i < a.length; i++) {
                a[i] = random.nextInt(100);
            }
            long l = System.currentTimeMillis();
            bubbleSort(a);
            sum += System.currentTimeMillis() - l;
        }
        System.out.println("耗时：" + sum/10);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = m + i - 1; j >= 0; j--) {
                if (nums2[i] < nums1[j]) {
                    nums1[j + 1] = nums1[j];
                    nums1[j] = nums2[i];
                } else {
                    nums1[j + 1] = nums2[i];
                    break;
                }
            }
            Arrays.stream(nums1).forEach(System.out::print);
            System.out.println();

        }
    }

    // 双指针
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        int mp = 0, np = 0;
        for (int i = 0; i < temp.length; i++) {
            if (mp < m && np < n) {
                if (nums1[mp] < nums2[np]) {
                    temp[i] = nums1[mp++];
                } else if (nums2[np] < nums1[mp]) {
                    temp[i] = nums2[np++];
                } else {
                    temp[i++] = nums1[mp++];
                    temp[i] = nums2[np++];
                }
                continue;
            }
            if (np < n) {
                temp[i] = nums2[np++];
                continue;
            }
            if (mp < m) {
                temp[i] = nums1[mp++];
            }

        }
        if (m >= 0) System.arraycopy(temp, 0, nums1, 0 ,temp.length);
    }

    public static void bubbleSort(int[] numbers) {
        if (numbers == null) {
            return;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            boolean changed = false;
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
    }

    public void bubbleSort2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        boolean switched;
        do {
            switched = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i+1] < numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                    switched = true;
                }
            }
        } while (switched);
    }

    public static void bubbleSort3(int[] numbers) {
       // 冒泡排序
       boolean flag = true;
       for (int i = 0; i < numbers.length - 1; i++) {
           for (int j = 0; j < numbers.length - i - 1; j++) {
               if (numbers[j+1] < numbers[j]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    flag = false;
               }
           }
           if (flag) {
               break;
           }
       }
    }

}
