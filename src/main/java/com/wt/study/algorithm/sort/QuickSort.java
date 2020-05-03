package com.wt.study.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort t = new QuickSort();
        int[] testData = {3, 2, 7, 10, 1, 9, 0, 5};
        t.quitSort(testData, 0, testData.length - 1);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            //从后往前开始比较，直到遇到比pivot小的数,将其移到low位置,此时high位置的数在[]中有两个
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            System.out.println(Arrays.toString(arr));
            //再从前开始比较，当然第一个a[low]是刚移过来的，low++,直到遇到比pivot小的数,将其替换到high位置的值
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
            System.out.println(Arrays.toString(arr));
        }
        //遍历到后来low>high时，结束
        arr[low] = pivot;
        System.out.println(Arrays.toString(arr));
        System.out.println("==============================");
        return low;
    }

    public void quitSort(int[] data, int low, int high) {
        if (low > high) {
            return;
        }
        int pivot = partition(data, low, high);
        quitSort(data, low, pivot - 1);
        quitSort(data, pivot + 1, high);
    }
}
