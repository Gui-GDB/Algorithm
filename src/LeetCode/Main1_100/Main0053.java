package LeetCode.Main1_100;

public class Main0053 {
    /**
     * 解题思路：
     * 这个问题就是求最大连续子序列和问题，显然利用动态规划的方法实现。
     * 重叠子问题：每一个数组可以看成时减去最后一个元素的数组的最大子数组的和。
     * 状态：dp[i] 表示序列以 F[i] 结尾的数组的最大子数组和。
     * 状态转移方程：dp[i] = max{F[i], dp[i - 1] + A[i]}，由于只使用到历史前一个数据，所以可以只使用开一个空间存储前一个状态的结果。
     * 时间复杂度 O(n)，空间复杂度：O(1)
     */
    public static int maxSubArray(int[] nums) {
        int dp = nums[0];
        int res = dp;
        for (int i = 1; i < nums.length; i++) {
            int temp = dp + nums[i];
            dp = Math.max(temp, nums[i]);
            res = Math.max(res, temp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
