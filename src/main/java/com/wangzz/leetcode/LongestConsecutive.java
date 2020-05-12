package com.wangzz.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(longestCount(new int[]{4,5,6,7,1,2}));
    }

    public static int longestCount(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        //全局最大长度
        int longest = 0;
        for (int num : numsSet) {
            //num是一连串数字的第一个数
            if (!numsSet.contains(num - 1)) {
                //当前数字
                int currentNum = num;
                //当前最大长度
                int currentLongest = 1;
                //如果set里有下一个数字，当前数字和当前长度均+1
                while (numsSet.contains(++currentNum)) {
                    currentLongest++;
                }
                longest = Math.max(currentLongest, longest);
            }
        }
        return longest;
    }

    /**
     * 暴力
     */
    static class Solution1 {
        private boolean arrayContains(int[] arr, int num) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == num) {
                    return true;
                }
            }

            return false;
        }
        public int longestConsecutive(int[] nums) {
            int longestStreak = 0;

            for (int num : nums) {
                int currentNum = num;
                int currentStreak = 1;
                while (arrayContains(nums, currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }

            return longestStreak;
        }
    }

    /**
     * 排序
     */
    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            //O(nlogn)
            Arrays.sort(nums);

            int longestStreak = 1;
            int currentStreak = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i-1]) {
                    if (nums[i] == nums[i-1]+1) {
                        currentStreak += 1;
                    }
                    else {
                        longestStreak = Math.max(longestStreak, currentStreak);
                        currentStreak = 1;
                    }
                }
            }

            return Math.max(longestStreak, currentStreak);
        }
    }

    /**
     * 哈希表和线性空间的构造
     */
    static class Solution3 {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);
            }

            int longestStreak = 0;

            for (int num : num_set) {
                if (!num_set.contains(num-1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum+1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
    }


}
