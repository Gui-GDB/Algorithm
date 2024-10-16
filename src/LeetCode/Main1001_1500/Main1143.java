package LeetCode.Main1001_1500;

public class Main1143 {
    /**
     * 经典的动态规划题目：最长公共子序列问题
     * 状态：令 dp[i][j] 表示字符串 A 的 i 号位与字符串 B 的 j 号位之间的最长公共子序列。
     * 状态转移方程：
     * ① A[i] == B[j]，dp[i][j] = dp[i-1][j-1] + 1;
     * ② A[i] != B[j], dp[i][j]= max{dp[i-1][j],dp[i][j-1]}
     * 边界：dp[i][0] = dp[0][j] = 0(0<=i<=n,o<=j<=m)
     * 时间复杂度：O(n*m)
     * 空间复杂度：O(n*m)
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (charArray1[i - 1] == charArray2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
