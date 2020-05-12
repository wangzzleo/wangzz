package com.wangzz.struct.recursion;

/**
 * @author wangzz
 * @date 2019年12月23日15:18:21
 */
public class MyPow {


    public static void main(String[] args) {
        System.out.println(pow2(2,10));
    }

    private static double pow1(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1/pow1(x, -n);
        return (n & 1) != 1 ? pow1(x * x, n >> 1) : pow1(x,  n - 1) * x;
    }

    private static double pow2(double x, int n) {
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        double pow = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                pow = x * pow;
            }
            x = x * x;
            n >>= 1;
        }
        return pow;
    }

    private static double pow3(double x, int n) {
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        double pow = 1;
        for (int i = n; i > 0; i--) {
            pow = pow * x;
        }
        return pow;
    }

}
