package com.wangzz.leetcode;

public class AlienRabbit {

    public static void main(String[] args) {
        System.out.println(rabbitCount(1));
        System.out.println(rabbitCount(2));
        System.out.println(rabbitCount(3));
        System.out.println(rabbitCount(4));
        System.out.println(rabbitCount(5));
        System.out.println(rabbitCount(6));
    }

    public static int rabbitCount(int months) {
        if (months == 1 || months == 2) {
            return 1;
        }
        return rabbitCount(months - 1) + rabbitCount(months - 2);
    }

}
