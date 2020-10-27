package com.wangzz.struct.sort;

import java.util.Arrays;

public class SortAlgorithm {

    public static void main(String[] args) {

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
    public void quickSort() {

    }

    public void mergeSort() {

    }
}
