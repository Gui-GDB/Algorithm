package LeetCode.Main1501_3000;

import java.util.*;

public class Main2848 {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
            res.get(i).add(sc.nextInt());
            res.get(i).add(sc.nextInt());
        }
        System.out.println(numberOfPoints(res));
    }

    /**
     * 时间复杂度：O(n+L)，n是list中的元素个数，L是List中两个数值的差值长度总和。
     */
    public static int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> num : nums) {
            int num1 = num.get(0);
            int num2 = num.get(1);
            for (int i=num1; i<=num2; i++) {
                set.add(i);
            }
        }
        return set.size();
    }
}
