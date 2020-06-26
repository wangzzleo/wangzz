package com.wangzz;

import org.junit.Test;

public class BinTest {

    @Test
    public void testBin() {
        System.out.println(Integer.toBinaryString(16384));
        System.out.println(Integer.toBinaryString(3089));

        System.out.println(16384&3089);
    }

}
