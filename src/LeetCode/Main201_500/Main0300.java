package LeetCode.Main201_500;

import java.util.HashMap;
import java.util.Set;

public class Main0300 {
    /**
     * 典型的动态规划：
     * 状态：令 dp[i] 表示以第i个元素结尾的最长递增子序列。
     * 状态转移存在下面两种情况：
     * ① 如果 A[i] 不大于前面任何一个最长递增子序列的最后一个元素时，则自己组成递增子序列，
     * ② 如果 A[i] 大于 dp[j] 最长递增子序列的最后一个元素时，则将 A[i] 加到 dp[j] 当中，更新最长递增子序列。
     * 时间复杂度优化：通过 hashmap保存每个长度下的子序列最后一个元素最小的一个即可，减少遍历。
     */
    public static int lengthOfLIS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, nums[0]);
        for (int i = 1; i < nums.length; i++) {
            Set<Integer> set = map.keySet();
            int temp = 1;
            for (Integer key : set) {
                int value = map.get(key);
                if (value < nums[i])
                    temp = Math.max(temp, key + 1);
            }
            map.put(temp, nums[i]);
        }
        Set<Integer> set = map.keySet();
        int res = 0;
        for (Integer key : set)
            res = Math.max(key, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1, 2, 3, 9, 5, 16, 7}));
    }
}
