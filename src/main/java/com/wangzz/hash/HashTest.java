package com.wangzz.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzz
 * @date
 */
public class HashTest {
    public static void main(String[] args) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Float variable = 0.1f;
        for (int i = 0; i < 1000000 ; i++) {
            //int loct = ((variable.hashCode()) ^ (variable.hashCode() >>> 16)) % 16;
            variable += 1;
//            if (cnt.containsKey(loct)) {
//                cnt.put(loct, cnt.get(loct) + 1);
//            } else {
//                cnt.put(loct, 1);
//            }
            System.out.println(Float.toHexString(variable));
        }
        System.out.println(cnt);
    }


}
