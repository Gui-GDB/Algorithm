package LeetCode.Main501_1000;

public class Main0746 {
    public static int[] dp = new int[1001];

    /**
     * 为了避免重复计算，开辟一个数组 dp，dp[i] 表示爬到第 i 个台阶的最小花费。
     */
    public static int minCostClimbingStairs(int[] cost) {
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
