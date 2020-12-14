package com.wangzz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null) {
            return result;
        }
        StringWrapper[] charSums = new StringWrapper[strs.length];
        for (int i=0;i<strs.length;i++) {
            charSums[i] = new StringWrapper(strs[i]);
        }
        Arrays.sort(charSums);
        List<String> innerList = new ArrayList<>();
        for (int i=0;i<charSums.length - 1;i++) {
            innerList.add(charSums[i].str);
            if (charSums[i].charSum != charSums[i+1].charSum) {
                result.add(innerList);
                innerList = new ArrayList<>();
            }
        }
        result.add(innerList);
        return result;
    }

    static class StringWrapper implements Comparable<StringWrapper> {
        int charSum;
        String str;

        public StringWrapper(int charSum, String str) {
            this.charSum = charSum;
            this.str = str;
        }

        public StringWrapper(String str) {
            this.charSum = charSum(str);
            this.str = str;
        }

        @Override
        public int compareTo(StringWrapper o) {
            return this.charSum - o.charSum;
        }
    }

    public static int charSum(String str) {
        int charSum = 0;
        for (char c : str.toCharArray()) {
            charSum += c;
        }
        return charSum;
    }


}
