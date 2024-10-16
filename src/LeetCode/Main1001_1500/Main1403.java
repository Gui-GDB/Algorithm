package LeetCode.Main1001_1500;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1403 {
    /**
     * 解题思路：
     * 首先将数组元素进行排序，然后统计数组中所有元素的总和，然后，从最大的元素开始依次添加元素，直到满足所有所有条件。
     * 时间复杂度：O(nlog n)
     * 空间复杂度：O(1)
     */
    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int value : nums)
            sum += value;
        int[] ints = mergeSort(nums, 0, nums.length - 1);
        int temp = 0, index = nums.length - 1;
        while (sum >= temp) {
            res.add(ints[index]);
            sum -= ints[index];
            temp += ints[index];
            index--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(minSubsequence(nums));
    }

    public static int[] mergeSort(int[] nums, int start, int end) {
        if (start == end)
            return new int[]{nums[start]};
        int mid = start + end >> 1;
        int[] leftArr = mergeSort(nums, start, mid);
        int[] rightArr = mergeSort(nums, mid + 1, end);
        int[] mergedArr = new int[leftArr.length + rightArr.length];
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length)
            mergedArr[k++] = leftArr[i] <= rightArr[j] ? leftArr[i++] : rightArr[j++];
        while (i < leftArr.length)
            mergedArr[k++] = leftArr[i++];
        while (j < rightArr.length)
            mergedArr[k++] = rightArr[j++];
        return mergedArr;
    }
}
