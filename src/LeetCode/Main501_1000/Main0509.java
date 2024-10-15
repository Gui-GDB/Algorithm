package LeetCode.Main501_1000;

import java.util.Scanner;

public class Main0509 {
    /**
     * 使用递归实现的方式
     * 时间复杂度O(2^n)
     * 空间复杂度O(1)
     */
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static int[] dp = new int[50];

    /**
     * 可以发现递归的方式存在大量的重复计算导致时间复杂度高。
     * 使用动态规划的方法：
     * 为了避免重复计算，可以开一个数组 dp,用以保存已经计算过的结果，其中 dp[n] 记录 F(n) 的计算结果，并用 dp[n] = 0 表示当前结果没有计算过。
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public static int fib2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != 0) return dp[n];
        dp[n] = fib2(n - 1) + fib2(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
    }
}
