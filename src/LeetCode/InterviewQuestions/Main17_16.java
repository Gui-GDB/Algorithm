package LeetCode.InterviewQuestions;

public class Main17_16 {
    /**
     * 状态转移方程：dp[i] = max{dp[i-1], dp[i-2] + A[i]}
     */
    public static int massage(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int dp1 = Math.max(nums[1], nums[0]), dp2 = nums[0];
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(nums[i] + dp2, dp1);
            dp2 = dp1;
            dp1 = temp;
        }
        return dp1;
    }

    public static void main(String[] args) {
        System.out.println(massage(new int[]{2, 1, 1, 2}));
    }
}
