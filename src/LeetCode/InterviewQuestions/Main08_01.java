package LeetCode.InterviewQuestions;


public class Main08_01 {
    public static int waysToStep(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;
        long dp1 = 4, dp2 = 2, dp3 = 1;
        for (int i = 4; i <= n; i++) {
            long temp = (dp1 + dp2 + dp3) % 1000000007;
            dp3 = dp2;
            dp2 = dp1;
            dp1 = temp;
        }
        return (int) dp1;
    }

    public static void main(String[] args) {
        System.out.println(waysToStep(61));
    }
}
