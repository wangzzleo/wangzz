package com.wangzz.struct.sort;

import java.util.Arrays;

public class SortAlgorithm {

    public static void main(String[] args) {
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int[] nums = new int[]{1,32,4,56,7};
        sortAlgorithm.quickSort(nums);
        Arrays.stream(nums).forEach(e -> System.out.print(e + " "));
    }

    // 冒泡
    public void bubbleSort(int[] numbers) {
        boolean numberSwitched;
        do {
            numberSwitched = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i+1] < numbers[i]) {
                    int temp = numbers[i+1];
                    numbers[i+1] = numbers[i];
                    numbers[i] = temp;
                    numberSwitched = true;
                }
            }
        } while (numberSwitched);
    }

    // 插入
    public void insertSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int curr = numbers[i];
            int index = i - 1;
            while (curr < numbers[index] && 0 <= index) {
                numbers[index + 1] = numbers[index--];
            }
            numbers[index+1] = curr;
        }
    }

    // 快速排序
    public void quickSort(int[] numbers) {
        if (numbers == null) {
            return;
        }
        quickSort(numbers, 0, numbers.length - 1);
    }

    public void quickSort(int[] numbers, int left, int right) {
        if (right <= left) {
            return;
        }
        int pivot = numbers[left];
        int start = left;
        int end = right;
        while (start < end) {
            while (start < end && pivot <= numbers[end]) {
                end--;
            }
            swapArr(numbers, start, end);
            while (start < end && numbers[start] <= pivot) {
                start++;
            }
            swapArr(numbers, start, end);
        }
        quickSort(numbers, left, start - 1);
        quickSort(numbers, start + 1, right);
    }

    private void swapArr(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }

    public void mergeSort() {

    }
}
