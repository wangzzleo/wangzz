package com.wangzz.ramdom;

import org.junit.Test;

import java.util.Random;
import java.util.SplittableRandom;

public class CompareRandom {

    @Test
    public void generateRandom() {
        long l1 = System.nanoTime();
        double random = Math.random();
        long l2;
        System.out.println((l2 = System.nanoTime()) - l1);
        double random2 = Math.random();
        System.out.println(System.nanoTime() - l2);

        SplittableRandom splittableRandom = new SplittableRandom();
    }

    @Test
    public void generateRandom2() {
        Random rnd1 = new Random(42);
        Random rnd2 = new Random(42);

        System.out.println(rnd1.nextInt(100)+" - "+rnd2.nextInt(100));
        System.out.println(rnd1.nextInt()+" - "+rnd2.nextInt());
        System.out.println(rnd1.nextDouble()+" - "+rnd2.nextDouble());
        System.out.println(rnd1.nextLong()+" - "+rnd2.nextLong());
    }

}
