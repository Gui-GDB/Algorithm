package LeetCode.InterviewQuestions;

public class Main16_17 {
    public static int maxSubArray(int[] nums) {
        int res = nums[0], dp = nums[0];
       for (int i = 1; i < nums.length; i++) {
           dp = Math.max(dp + nums[i], nums[i]);
           res = Math.max(res, dp);
       }
       return res;
    }
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
