package com.wangzz.struct.reverse;

public class Solution {

    /**
     * 翻转整数
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x%10;
            x = x/10;
        }
        return reverse > 0x7fffffff || reverse < 0x80000000 ? 0 : (int) reverse;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int temp = x;
        while (temp != 0) {
            reverse = reverse*10 + temp%10;
            temp = temp/10;
        }
        return reverse == x;
    }

}
