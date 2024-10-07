package algorithmTemplate;

import java.util.Arrays;

/**
 * 可以利用LeetCode上的第912题来练习自己写的排序算法是否正确
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {110, 100, 0};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序实现升序排序，
     *
     * @param arr 待排序的数组
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i], j;
                for (j = i - 1; j >= 0 && arr[j] > temp; j--)
                    arr[j + 1] = arr[j];
                arr[j + 1] = temp;
            }
        }
    }

    /**
     * 选择排序实现升序排序
     *
     * @param arr 待排序的数组
     */
    public static void selectionSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            swap(arr, i, min);
        }
    }

    /**
     * 冒泡排序实现升序排序
     *
     * @param arr 待排序的数组
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 归并排序实现升序排序算法
     * 首先就是通过递归的方式将数据划分成一个一个的元素，然后通过归并的方法将数组排序。
     *
     * @param arr   带排序的数组
     * @param left  目标数组待排序的左指针
     * @param right 目标数组待排序的右指针
     * @return 返回归并后的有序数组
     */
    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left == right)
            return new int[]{arr[left]};
        int mid = left + right >> 1;
        int[] leftArr = mergeSort(arr, left, mid);
        int[] rightArr = mergeSort(arr, mid + 1, right);
        int[] mergeArr = new int[leftArr.length + rightArr.length];

        int index = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length)
            mergeArr[index++] = leftArr[i] <= rightArr[j] ? leftArr[i++] : rightArr[j++];
        while (i < leftArr.length)
            mergeArr[index++] = leftArr[i++];
        while (j < rightArr.length)
            mergeArr[index++] = rightArr[j++];
        return mergeArr;
    }

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
}
