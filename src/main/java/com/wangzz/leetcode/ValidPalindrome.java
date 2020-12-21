package com.wangzz.leetcode;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String copyStr = s.toLowerCase();
        int left = 0;
        int right = copyStr.length() - 1;
        while (left < right) {
            char leftChar;
            while (!Character.isLetterOrDigit(leftChar = copyStr.charAt(left)) && left < right) {
                left++;
            }
            char rightChar;
            while (!Character.isLetterOrDigit(rightChar = copyStr.charAt(right)) && left < right) {
                right--;
            }
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
