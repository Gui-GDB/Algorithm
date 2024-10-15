package LeetCode.Main1_100;

public class Main0070 {
    /**
     * 解题思路：分析可以发现规律，这个题目存在重叠子问题，即可以看成 F(n) = F(n-1) + F(n-2),使用递归即可简单求解
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(1)
     *
     * @param n 总的台阶的数量
     * @return 返回走到这步台阶的所有情况数
     */
    public static int climbStairs(int n) {
        //递归条件
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int[] dp = new int[50];

    /**
     * 分析知道这个题目拥有重叠子问题，可以使用记忆化搜索的方式来降低时间复杂度。
     * 为了避免重复计算，可以开一个一维数组 dp,用以保存以及计算过的结果，其中 dp[n] 记录 F(n)的计算结果，并用 dp[n] = 0 表示 F(n) 当前还没有被计算过。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param n 表示当前的阶梯数
     * @return 一共有多少中走的方式。
     */
    public static int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (dp[n] != 0) return dp[n];
        dp[n] = climbStairs2(n - 1) + climbStairs2(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
