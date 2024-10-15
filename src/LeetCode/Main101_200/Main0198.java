package LeetCode.Main101_200;

public class Main0198 {
    /**
     * 通过观察分析可以知道这个题目可以使用动态规划
     * 状态 dp[i] 表示有 i 个房间能够偷取的最大价值
     * 状态转移方程：dp[i] = max{A[i] + dp[i-2], dp[i-1]}
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int dp1 = nums[0], dp2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(nums[i] + dp1, dp2);
            dp1 = dp2;
            dp2 = temp;
        }
        return dp2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
