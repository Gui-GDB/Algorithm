package LeetCode.Main1501_3000;

import java.util.Scanner;

public class Main1913 {
    /**
     * 解题思路：遍历数组，直接寻找最大的两个元素和最小的两个元素
     * 时间复杂度：O(n)
     */
    public static int maxProductDifference(int[] nums) {
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        int c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        for (int value : nums) {
            if (value > a) {
                b = a;
                a = value;
            }
            else if (value > b)
                b = value;
            if (value < d) {
                c = d;
                d = value;
            }
            else if(value < c)
                c = value;
        }
        return a * b - c * d;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxProductDifference(nums));
    }
}
