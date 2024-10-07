package LeetCode.Main501_1000;

import algorithmTemplate.Sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 这个题目是用来练习排序的。
 */
public class Main0912 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] mergeSort = Sort.mergeSort(arr, 0, arr.length - 1);
        System.out.println("归并排序算法： " + Arrays.toString(mergeSort));

        int[] quickSort1 = Arrays.copyOf(arr, arr.length);
        Sort.quickSort1(quickSort1, 0, quickSort1.length - 1);
        System.out.println("快速排序算法1：" + Arrays.toString(quickSort1));

        int[] quickSort2 = Arrays.copyOf(arr, arr.length);
        Sort.quickSort2(quickSort2, 0, quickSort2.length - 1);
        System.out.println("快速排序算法2：" + Arrays.toString(quickSort2));

        System.out.println("元素数组数据： " + Arrays.toString(arr));
    }
}
