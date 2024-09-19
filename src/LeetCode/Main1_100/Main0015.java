package LeetCode.Main1_100;

import java.util.*;

public class Main0015 {
    /**
     * 时间复杂度：O(n^2)
     *
     * @param nums 待处理的数组
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums, 0, nums.length);
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int index = left + 1, temp = right;
            while (left < temp) {
                while (index < temp) {
                    int sum = nums[left] + nums[temp] + nums[index];
                    if (sum == 0) {
                        String num = String.valueOf(nums[left]);
                        num += String.valueOf(nums[temp]);
                        num += String.valueOf(nums[index]);
                        if (!set.contains(num)) {
                            set.add(num);
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[left]);
                            list.add(nums[index]);
                            list.add(nums[temp]);
                            res.add(list);
                        }
                    } else if (sum > 0)
                        break;
                    index++;
                }
                temp--;
            }
            left++;
        }
        return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums, 0, nums.length);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int right = nums.length - 1;
            for (int left = i + 1; left < right; left++) {
                if (left > i + 1 && nums[left] == nums[left - 1])
                    continue;
                while (left < right && nums[i] + nums[left] + nums[right] > 0)
                    right--;
                if (left == right)
                    break;
                if (nums[i] + nums[left] + nums[right] == 0)
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(threeSum2(nums));
    }
}
