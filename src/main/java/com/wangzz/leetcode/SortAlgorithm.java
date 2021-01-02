package com.wangzz.leetcode;

import java.util.Arrays;

public class SortAlgorithm {

    public static void main(String[] args) {
        int[] arr = {2,43,1,5,12,4,12,45,1,4,13,5,6,21,10};
        quickSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && pivot <= arr[right]) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
        }
        arr[left] = pivot;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

}
