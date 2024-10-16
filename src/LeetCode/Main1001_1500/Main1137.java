package LeetCode.Main1001_1500;

public class Main1137 {
    public static int[] dp = new int[41];

    /**
     * 使用递归就可以实现，可以使用动态规划减少重复计算，降低时间复杂度。
     * 状态：令 dp[i] 表示第 i 个泰波那契数。
     * 状态转移方程：dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
     * 边界：dp[0] = 0, dp[1] = dp[2] = 1
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (dp[n] != 0) return dp[n];
        dp[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        return dp[n];
    }

    /**
     * 通过递推的方式实现
     */
    public static int tribonacci2(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] dp = new int[]{0, 1, 1};
        for (int i = 3; i <= n; i++) {
            int temp = dp[0] + dp[1] + dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = temp;
        }
        return dp[2];
    }


    public static void main(String[] args) {
        System.out.println(tribonacci2(25));
    }
}
