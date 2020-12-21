package com.wangzz.struct.sort;

import java.util.Arrays;

public class SortAlgorithm {

//    public static void main(String[] args) {
////        SortAlgorithm sortAlgorithm = new SortAlgorithm();
////        int[] nums = new int[]{4,3,2,1};
////        sortAlgorithm.quickSort(nums);
////        Arrays.stream(nums).forEach(e -> System.out.print(e + " "));
//        try {
//            System.out.println(testThrow());
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//    }

    public static String testThrow() {
        try {
            int a = 1/0;
            return "a";
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            return "c";
        }
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

    public static void main(String[] args) {
        int[] numbers = new int[]{5,2,3,1,1};
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        sortAlgorithm.quickSort(numbers);
        Arrays.stream(numbers).forEach(System.out::print);
    }

    // 快速排序
    public void quickSort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    public void quickSort1(int[] a, int low, int hight) {
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
        quickSort1(a, low, i - 1); // 对低子表进行递归排序
        quickSort1(a, i + 1, hight); // 对高子表进行递归排序
        quickSort1(a, 0, a.length - 1);
    }

    int count = 0;
    public void quickSort(int[] numbers, int left, int right) {
        if (right <= left) {
            return;
        }
        System.out.println(++count);
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
        quickSort(numbers, left, end - 1);
        quickSort(numbers, end + 1, right);
    }

    private void swapArr(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }

    // 归并排序
    public void mergeSort() {

    }

    // 选择排序
    public void selectionSort() {
    }
    public static void bubbleSort2(int[] arr) {
        if (arr == null) {
            return;
        }
        boolean isChange = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isChange = true;
                }
            }
            if (!isChange) {
                break;
            }
        }
    }
}
