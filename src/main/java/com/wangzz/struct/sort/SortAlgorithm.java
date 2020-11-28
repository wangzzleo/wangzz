package com.wangzz.struct.sort;

import java.util.Arrays;

public class SortAlgorithm {

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

    public static void main(String[] args) {
        int[] numbers = new int[]{5,2,3,1};
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        sortAlgorithm.quickSort(numbers);
        Arrays.stream(numbers).forEach(System.out::print);
    }

    // 快速排序
    public void quickSort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    public void quickSort(int[] a, int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        quickSort(a, low, i - 1); // 对低子表进行递归排序
        quickSort(a, i + 1, hight); // 对高子表进行递归排序
    }

    // 归并排序
    public void mergeSort() {

    }

    // 选择排序
    public void selectionSort() {

    }
}
