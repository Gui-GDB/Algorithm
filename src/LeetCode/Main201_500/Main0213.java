package LeetCode.Main201_500;

public class Main0213 {
    /**
     * 解题思路：在题目198上面增加了首尾相连的条件，于是可以看成两个序列然后分别求最大偷窃的结果，最后两个值取最大值即可。
     */
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        // 从第1~n-1间房屋能够偷盗的最大价值
        int dp1_1 = nums[0], dp1_2 = Math.max(nums[0], nums[1]);
        // 从第2~n间房屋能够偷盗的最大价值
        int dp2_1 = nums[1], dp2_2 = Math.max(nums[1], nums[2]);

        for (int i = 3; i < nums.length; i++) {
            int temp1 = Math.max(dp1_1 + nums[i-1], dp1_2);
            int temp2 = Math.max(dp2_1 + nums[i], dp2_2);
            dp1_1 = dp1_2;
            dp1_2 = temp1;
            dp2_1 = dp2_2;
            dp2_2 = temp2;
        }
        return Math.max(dp1_2, dp2_2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
