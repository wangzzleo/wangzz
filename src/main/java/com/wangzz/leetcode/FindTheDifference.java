package com.wangzz.leetcode;

public class FindTheDifference {

    public static void main(String[] args) {
        FindTheDifference solution = new FindTheDifference();
        System.out.println(solution.findTheDifference(
                "abc",
                "abcd"));
        System.out.println("时间复杂度：" + solution.count);
    }

    private int count = 0;

    public char findTheDifference(String s, String t) {
        String tempS = s;
        String tempT = t;
        for (int i = 0; i< tempT.length(); i++) {
            for (int j = 0; j< tempS.length(); j++) {
                if (tempT.charAt(i) == tempS.charAt(j)) {
                    tempS = tempS.substring(0,j) + tempS.substring(j+1);
                    tempT = tempT.substring(0,i) + tempT.substring(i+1);
                    i--;
                    count++;
                    break;
                }
            }
        }
        return tempT.charAt(0);
    }

}
