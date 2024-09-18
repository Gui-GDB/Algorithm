package algorithmTemplate;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {

    /**
     * 快速排序实现升序排序
     * 在具体实现的时候，对于数据交换的时机有很多种选择
     *
     * @param arr   待排序的数组
     * @param start 左指针
     * @param end   右指针
     */
    public static void quickSort1(int[] arr, int start, int end) {
        //数组有多个元素进行排序
        if (start < end) {
            int base = arr[start], left = start, right = end;
            while (left < right) {
                //从右向左找，比base大，right--
                while (left < right && arr[right] >= base)
                    right--;
                //比base小，替换left所在位置的数字
                arr[left] = arr[right];
                //从左向右找，比base小，left++
                while (left < right && arr[left] <= base)
                    left++;
                //比base大，替换right所在位置的数字
                arr[right] = arr[left];
            }
            //此时left=right，用base替换这个位置的数字
            arr[left] = base;
            //排列比base小的数字的数组
            quickSort1(arr, start, left - 1);
            //排列比base大的数字的数组
            quickSort1(arr, left + 1, end);
        }
    }

    public static void quickSort2(int[] arr, int start, int end) {
        if (start < end) {
            int base = arr[start], left = start, right = end;
            while (left < right) {
                //要保证右边的比基准元素大
                while (left < right && arr[right] >= base)
                    right--;
                //要保证左边的比基准元素小
                while (left < right && arr[left] <= base)
                    left++;
                swap(arr, left, right);
            }
            //此时left==right
            swap(arr, start, left);
            quickSort2(arr, start, left - 1);
            quickSort2(arr, left + 1, end);
        }
    }

    /**
     * 交换数组中的两个元素
     *
     * @param arr 待交换元素的数组
     * @param i   需要交换元素的数组下标
     * @param j   需要交换元素的数组下标
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 100000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort2(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
}
