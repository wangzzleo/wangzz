package com.wangzz.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzz
 * @date
 */
public class InfiniteRecursion {

    @Override
    public String toString() {
        return "InfiniteRecursion address : " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        String a = "abc1";
        String b = "abc";
        System.out.println(a.compareTo(b));
    }

}
