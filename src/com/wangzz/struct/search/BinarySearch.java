package com.wangzz.struct.search;

/**
 * @author wangzz
 * @date 2019年12月30日14:28:24
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11}, 2));
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

    public double sqrt() {
        return 0;
    }

}
