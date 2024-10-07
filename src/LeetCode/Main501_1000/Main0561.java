package LeetCode.Main501_1000;

import java.util.Scanner;

public class Main0561 {
    public static int arrayPairSum(int[] nums) {
        int length = nums.length;
        quickSort(nums, 0, length - 1);
        int res = 0;
        for (int i = 0; i < length; i += 2) {
            res += nums[i];
        }
        return res;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            //首先设置基准元素
            int base = nums[left], start = left, end = right;
            //一直循环直到满足数组左边的元素都小于基准元素，数组右边的元素都大于基准元素
            while (start < end) {
                //首先从右边找到一个小于基准元素的元素
                while (start < end && nums[end] >= base)
                    end--;
                //从左边找到一个大于基准元素的元素
                while (start < end && nums[start] <= base)
                    start++;
                if (start < end)
                    swap(nums, start, end);
            }
            swap(nums, start, left);
            quickSort(nums, left, start - 1);
            quickSort(nums, start + 1, right);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(arrayPairSum(nums));
    }
}
