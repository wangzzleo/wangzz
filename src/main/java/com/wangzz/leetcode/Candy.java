package com.wangzz.leetcode;

/**
 * 135
 */
public class Candy {

    public static void main(String[] args) {
        System.out.println(new Candy().candy(new int[]{1,2,3,1,0}));
    }

    public int candy(int[] ratings) {
        if(ratings == null) {
            return 0;
        }
        int[] count = new int[ratings.length];
        count[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            // 如果评分比上一个高，则糖果数为上一个糖果+1
            if (ratings[i - 1] < ratings[i]) {
                count[i] = count[i - 1] + 1;
            } else if(ratings[i - 1] == ratings[i]) {
                // 如果评分和上一个相等，则糖果数1
                count[i] = 1;
            } else {
                // 如果评分比上一个低，则糖果数1
                count[i] = 1;
                // 如果此时两个糖果数相等，此时之前的可能不平衡
                if(count[i - 1] == count[i]) {
                    // 对上一个糖果数目+1
                    count[i - 1] = count[i - 1] + 1;
                    for (int j = i - 1; j > 0; j--) {
                        if(ratings[j] == ratings[j - 1]) {
                            // 评分相等，则无所谓
                            break;
                        } else if (ratings[j - 1] < ratings[j]) {
                            // 评分大于上一个
                            if(count[j] <= count[j - 1]) {
                                // 糖果数小于等于上一个
                                count[j] = count[j] + 1;
                            }
                            break;
                        } else  {
                            // 评分小于上一个
                            if(count[j] < count[j - 1]) {
                                // 糖果数小于上一个
                                break;
                            } else {
                                // 糖果数大于等于上一个
                                count[j - 1] = count[j - 1] + 1;
                            }
                        }
                    }
                }
            }
        }
        int total = 0;
        for (int i : count) {
            total += i;
        }
        return total;
    }
}
