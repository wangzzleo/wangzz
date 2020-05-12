package com.wangzz.struct.search;

/**
 * @author wangzz
 * @date 2019年12月30日14:28:24
 */
public class BinarySearch {

    public static void main(String[] args) {
//        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11}, 2));
        System.out.println(sqrt(2, 10));
        System.out.println(Math.pow(10, -10));
    }

    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = right / 2;
            if (target == arr[middle]) {
                return middle;
            } else if (target > arr[middle]) {
                left = middle;
            } else if (target < arr[middle]) {
                right = middle;
            }
        }
        return -1;
    }

    public static double sqrt(double root, int eps) {
        double left = 0;
        double right = root;
        double accuracyValue = Math.pow(10, -eps);
        double middle = 0;
        while (right - left > accuracyValue) {
            middle = (left + right) /2;
            System.out.print("left=" + left);
            System.out.print(" right="+right);
            System.out.println(" middle="+middle);
            if (middle * middle == root) {
                return middle;
            } else if (middle * middle < root) {
                left = middle;
            } else if (middle * middle > root) {
                right = middle;
            }
        }
        return middle;
    }

}
