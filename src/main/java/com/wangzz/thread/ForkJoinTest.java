package com.wangzz.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ForkJoinTest {

    public static void main(String[] args) {
        //double random1 = Math.random();
        double v = ThreadLocalRandom.current().nextDouble();
        Random random = new Random();
        int[] arr = new int[1<<29];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        long start = System.nanoTime();
        //Arrays.sort(arr);
        System.out.println(System.nanoTime() - start);
        long start2 = System.nanoTime();
        Arrays.parallelSort(arr);
        System.out.println(System.nanoTime() - start2);
    }
    /**
     *  This class implements the java.util.Random API (and subclasses
     *  Random) using a single static instance that accesses random
     *  number state held in class Thread (primarily, field
     *  threadLocalRandomSeed). In doing so, it also provides a home
     *  for managing package-private utilities that rely on exactly the
     *  same state as needed to maintain the ThreadLocalRandom
     *  instances. We leverage the need for an initialization flag
     *  field to also use it as a "probe" -- a self-adjusting thread
     *  hash used for contention avoidance, as well as a secondary
     *  simpler (xorShift) random seed that is conservatively used to
     *  avoid otherwise surprising users by hijacking the
     *  ThreadLocalRandom sequence.  The dual use is a marriage of
     *  convenience, but is a simple and efficient way of reducing
     *  application-level overhead and footprint of most concurrent
     *  programs.
     *
     *  Even though this class subclasses java.util.Random, it uses the
     *  same basic algorithm as java.util.SplittableRandom.  (See its
     *  internal documentation for explanations, which are not repeated
     *  here.)  Because ThreadLocalRandoms are not splittable
     *  though, we use only a single 64bit gamma.
     *
     *  Because this class is in a different package than class Thread,
     *  field access methods use Unsafe to bypass access control rules.
     *  To conform to the requirements of the Random superclass
     *  constructor, the common static ThreadLocalRandom maintains an
     *  "initialized" field for the sake of rejecting user calls to
     *  setSeed while still allowing a call from constructor.  Note
     *  that serialization is completely unnecessary because there is
     *  only a static singleton.  But we generate a serial form
     *  containing "rnd" and "initialized" fields to ensure
     *  compatibility across versions.
     *
     *  Implementations of non-core methods are mostly the same as in
     *  SplittableRandom, that were in part derived from a previous
     *  version of this class.
     *
     *  The nextLocalGaussian ThreadLocal supports the very rarely used
     *  nextGaussian method by providing a holder for the second of a
     *  pair of them. As is true for the base class version of this
     *  method, this time/space tradeoff is probably never worthwhile,
     *  but we provide identical statistical properties.
     */
}
